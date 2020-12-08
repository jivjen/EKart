package com.infy.ekart.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infy.ekart.dto.LoginDTO;
import com.infy.ekart.dto.ProductCartDTO;
import com.infy.ekart.dto.ProductDTO;
import com.infy.ekart.dto.ReturnDTO;
import com.infy.ekart.dto.UserDTO;
import com.infy.ekart.entity.UserEntity;
import com.infy.ekart.exception.UserException;
import com.infy.ekart.service.UserService;



@CrossOrigin
@RestController
public class UserController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	RestTemplate template;
	
	@Autowired
	private UserService userService;
	
	
	
	/* ********************************************* */
	@GetMapping("/check")
	public String check()
	{
		return "yes";
	}
	@PostMapping("/login1")
	public ResponseEntity<String> pp(@RequestBody UserEntity u) throws UserException {
		    String response;
		    //logger.info("Inside loginCoach() method of {}", this.getClass());
			response=userService.pp(u);
			return new ResponseEntity<String>(response,HttpStatus.OK);
		}
	
	
	/* ************************************* */
	
	@PostMapping("/login/user")
	public ResponseEntity<ReturnDTO> loginUser(@RequestBody LoginDTO loginDto) throws UserException {
		    String response;
		    //logger.info("Inside loginCoach() method of {}", this.getClass());
		    ReturnDTO dto=new ReturnDTO();
		    dto.setUserId(loginDto.getUserId());
			response=userService.loginUser(loginDto);
			return ResponseEntity.ok(dto);
		
		}
	
	@PostMapping(value = "/{userId}/modifycart",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> modifyCart(@PathVariable("userId")String userId,@Valid @RequestBody ProductCartDTO productCartDTO, Errors error) {
		logger.info("modifycart request for user {}", productCartDTO);

		if(error.hasErrors())
		{
			String errMsgString = error.getFieldErrors().stream().map(x->x.getField() + " : "+x.getDefaultMessage()).collect(Collectors.joining(", "));
			return ResponseEntity.ok(errMsgString);
		}
		String response= template.postForObject("http://EKartCartMS/"+userId+"/modifycart",productCartDTO, String.class);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping(value = "/{userId}/update",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateProfile(@PathVariable("userId")String userId,@Valid @RequestBody UserDTO userDTO, Errors error) throws UserException {
		logger.info("Update profile request for user for userId {} "+userId,userDTO);
		if(error.hasErrors())
		{
			String errMsgString = error.getFieldErrors().stream().map(x->x.getField() + " : "+x.getDefaultMessage()).collect(Collectors.joining(", "));
			return ResponseEntity.ok(errMsgString);
		}
		return ResponseEntity.ok(userService.updateProfile(userDTO,userId));
	}
		
		@GetMapping(value = "/deals",produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<ProductDTO>> getDeals()
		{
			logger.info("Deals request for user");
			List<ProductDTO> productDTOs= template.getForObject("http://EKartProductMS"+"/deals", List.class);
			return ResponseEntity.ok(productDTOs);
		}
		
		@GetMapping(value = "/{userId}/recommendations",produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<ProductDTO>> getRecommendations(@PathVariable("userId")String userId)
		{
			logger.info("Reccomendations request for user "+userId);
			List<ProductDTO> productDTOs= template.getForObject("http://EKartOrderMS/"+userId+"/recommendations", List.class);
			return ResponseEntity.ok(productDTOs);
		}
}
