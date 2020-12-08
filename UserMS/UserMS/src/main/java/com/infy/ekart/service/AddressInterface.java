package com.infy.ekart.service;

import org.springframework.util.MultiValueMap;
import java.util.*;
import com.infy.ekart.dto.AddressDTO;
import com.infy.ekart.exception.UserException;



public interface AddressInterface {

	List<AddressDTO> viewAddress(String userid) throws UserException;

}
