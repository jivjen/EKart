package com.infy.ekart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.infy.ekart.dto.AddressDTO;
import com.infy.ekart.entity.AddressEntity;
import com.infy.ekart.exception.ExceptionConstants;
import com.infy.ekart.exception.UserException;
import com.infy.ekart.repository.AddressRepository;
import java.util.*;

@Service
@PropertySource("classpath:ValidationMessages.properties")
public class AddressService implements AddressInterface{

	
	@Autowired
	AddressRepository addressRepository;
	
	
	
	public List<AddressDTO> viewAddress(String userId) throws UserException{
		// TODO Auto-generated method stub
		
		
			
			List<AddressDTO> addresslist=new ArrayList<AddressDTO>();
			
			List<AddressEntity> addressEntites=null;
		
			
			
			addressEntites=addressRepository.findByUserId(userId);
			
			if(addressEntites.size()!=0) {
				
				for(AddressEntity adres: addressEntites) {
					AddressDTO address=AddressEntity.valueOf(adres);
					addresslist.add(address);
				}
			}
			else {
				throw new UserException(ExceptionConstants.ADDRESS_NOT_FOUND.toString());
			
			}
			
			
			return addresslist;
		
	}

}
