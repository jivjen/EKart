package com.infy.ekart.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.infy.ekart.dto.LoginDTO;
import com.infy.ekart.dto.UserDTO;
import com.infy.ekart.entity.UserEntity;
import com.infy.ekart.exception.ExceptionConstants;
import com.infy.ekart.exception.UserException;
import com.infy.ekart.repository.UserRepository;

@Service
public class UserService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private Environment environment;
	
	/**********************************8  */
	public String pp(UserEntity u)
	{
		userRepository.saveAndFlush(u);
		return "ok";
	}
	
	/* *************************8  */
	//@Override
	public String loginUser(LoginDTO loginDto) throws UserException {
		String response="";
		System.out.println(loginDto.toString());
		Optional<UserEntity> user=userRepository.findById(loginDto.getUserId());
		System.out.println(user.toString());
		if(user.isPresent())
		{
			if(loginDto.getPassword().equals(user.get().getPassword()))
			{
				logger.info("Success: Loggedin");
				return "User logged in succesfully";
			}
			logger.info("Failed: Incorrect password");
			response = ExceptionConstants.USER_NOT_FOUND.toString();
			throw new UserException(response);
		}
		response = ExceptionConstants.USER_NOT_FOUND.toString();
		logger.error("Error: " + response);
		throw new UserException(response);
	}
	
	public String updateProfile(UserDTO userDTO, String userId) throws UserException {
		
		Optional<UserEntity> userEntityOpt = userRepository.findByUserId(userId);
		if(!userEntityOpt.isPresent())
		{
			throw new UserException(environment.getProperty(ExceptionConstants.USER_NOT_FOUND.toString()));
		}
		UserEntity userEntity = userEntityOpt.get();
		userEntity.setPassword(userDTO.getPassword());
		userEntity.setName(userDTO.getName());
		userRepository.saveAndFlush(userEntity);
		return "Profile update successfull";
	}
}
