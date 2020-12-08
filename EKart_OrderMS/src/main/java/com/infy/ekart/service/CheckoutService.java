package com.infy.ekart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.infy.ekart.dto.CartDTO;
import com.infy.ekart.dto.CartDetailsDTO;



@Service
public class CheckoutService implements CheckoutInterface {

	@Override
	public CartDTO getCartDetails(String userId) {
		
		List<CartDetailsDTO> listcartitems=new ArrayList<>();
		
		CartDetailsDTO cartDetailsDTO1=new CartDetailsDTO("Mobile", "Electronics", "Naveen", 31999, 25, 1, 31999, 0);
		CartDetailsDTO cartDetailsDTO2=new CartDetailsDTO("Bat", "Wood", "Sai", 2999, 37, 2, 5998, 0);

		
		listcartitems.add(cartDetailsDTO1);
		listcartitems.add(cartDetailsDTO2);

		
		double totalPrice=0;
		double totalDeliveryCharge=0;
		double grandTotal=0;
		
		for(CartDetailsDTO item:listcartitems) {
			
			totalPrice+=item.getTotal();
			totalDeliveryCharge+=item.getDeliveryCharge();
			grandTotal=totalPrice+totalDeliveryCharge;
			
		}
		
		
		CartDTO cart=new CartDTO();
		
		cart.setCartItems(listcartitems);
		cart.setTotalDeliveryCharge(totalDeliveryCharge);
		cart.setTotalPrice(totalPrice);
		cart.setGrandTotal(grandTotal);
		return cart;
	}
	
	




}

