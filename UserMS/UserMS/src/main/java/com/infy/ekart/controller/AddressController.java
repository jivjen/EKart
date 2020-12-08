package com.infy.ekart.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infy.ekart.dto.AddressDTO;
import com.infy.ekart.exception.UserException;
import com.infy.ekart.service.AddressInterface;



@RestController

public class AddressController {

	
	
	@Autowired
	AddressInterface addressService;
	
	
	@RequestMapping(value = "/{userId}/address", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<AddressDTO>> viewAddress(@PathVariable("userId") String userId) throws UserException{
	
		ResponseEntity<List<AddressDTO>> responseEntity=null;
		
		List<AddressDTO> address=addressService.viewAddress(userId);
		
		return new ResponseEntity<List<AddressDTO>>(address,HttpStatus.OK);
		
	}
	
}
