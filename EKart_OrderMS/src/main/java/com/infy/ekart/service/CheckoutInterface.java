package com.infy.ekart.service;

import com.infy.ekart.dto.CartDTO;

public interface CheckoutInterface {


	CartDTO getCartDetails(String userId);
}
