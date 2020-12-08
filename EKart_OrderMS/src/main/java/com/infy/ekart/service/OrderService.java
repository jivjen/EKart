package com.infy.ekart.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.infy.ekart.dto.OrderDTO;
import com.infy.ekart.dto.OrderDetails;
import com.infy.ekart.dto.OrderStatusConstants;
import com.infy.ekart.dto.ProductDTO;
import com.infy.ekart.dto.SellerDTO;
import com.infy.ekart.entity.OrderEntity;
import com.infy.ekart.exception.ExceptionConstants;
import com.infy.ekart.exception.UserException;
import com.infy.ekart.repository.OrderRepository;

@Service
public class OrderService implements OrderInterface {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	RestTemplate template;
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	ProductFeign productFeign;
	@Autowired
	SellerFeign sellerFeign;
	@Override
	public List<ProductDTO> getRecommendations(String userId) {
		List<OrderEntity> orderEntities = orderRepository.findOrders(userId);
		List<Integer> productIdsIntegers = new ArrayList<>();
		for (OrderEntity orderEntity : orderEntities) {
			productIdsIntegers.add(orderEntity.getProductId());

		}

		// Integer ss[] =new Integer[productIdsIntegers.size()];
		Integer ss[] = productIdsIntegers.toArray(new Integer[productIdsIntegers.size()]);
		String result = Arrays.stream(ss).map(String::valueOf).collect(Collectors.joining(","));
		String urlString = "http://EKartProductMS" + "/product/?ids=" + result;
		logger.info(urlString);

		List<ProductDTO> productDTOs = template.getForObject(urlString, List.class);
		return productDTOs;
	}

	@Override
	public ResponseEntity<Integer> place_order(String userId, String data) throws UserException {

		JSONObject obj = new JSONObject(data);
		JSONArray Products = obj.getJSONArray("orderItems");
		JSONObject Address = obj.getJSONObject("addressDetails");
		JSONObject Payment = obj.getJSONObject("paymentMethod");

		// Card Expiry date check
		String expiryDate = Payment.getString("expiryMonth") + "/" + Payment.getString("expiryYear");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/[uuuu][uu]");
		TemporalAccessor cardDate = formatter.parse(expiryDate);
		LocalDate currentDate = LocalDate.now();
		if (currentDate.getYear() > cardDate.get(ChronoField.YEAR)) {
			throw new UserException(ExceptionConstants.CARD_EXPIRED.toString());
		} else if (currentDate.getYear() == cardDate.get(ChronoField.YEAR)) {
			if (currentDate.getMonthValue() >= cardDate.get(ChronoField.MONTH_OF_YEAR)) {
				throw new UserException(ExceptionConstants.CARD_EXPIRED.toString());
			}
		}

		// New Order
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setStatus(OrderStatusConstants.ORDER_PLACED.toString());
		orderDTO.setProductId(Products.getJSONObject(0).getInt("productId")); // here too
		orderDTO.setSellerId(Products.getJSONObject(0).getString("sellerId")); // here too
		orderDTO.setQuantity(Products.getJSONObject(0).getInt("quantity"));
		orderDTO.setOrderDate(LocalDate.now());

		orderDTO.setAddressId(Address.getInt("pinCode"));

		orderDTO.setPaymentType(Payment.getString("paymentMode")); // Change input
		orderDTO.setCardId(Payment.getInt("cardId"));
		orderDTO.setUserId(userId);

		OrderEntity orderEntity = orderDTO.createOrderEntity();
		orderRepository.save(orderEntity);

		return new ResponseEntity<>(orderEntity.getOrderId(), HttpStatus.OK);
	}

	@Override
	public List<OrderDetails> getOrders(String userId) {
		List<OrderEntity> orders = orderRepository.findByUserId(userId);
		List<ProductDTO> products = new ArrayList<>();
		List<SellerDTO> sellers = new ArrayList<>();
		
		
		orders.forEach((o)->{products.add(productFeign.getProductDetails(o.getProductId()));
		sellers.add(sellerFeign.getSellerDetails(o.getSellerId()));});
		
		List<OrderDetails> orderDetails = new ArrayList<>();
		for(int i = 0;i<orders.size();i++)
		{
			OrderDetails o = new OrderDetails();
			o.setCategory(products.get(i).getCategory());
			o.setDisplayName(products.get(i).getDisplayName());
			o.setOrderedDate(orders.get(i).getOrderDate());
			o.setOrderStatus(orders.get(i).getStatus());
			o.setPrice(products.get(i).getPrice());
			o.setQuantity(orders.get(i).getQuantity());
			o.setSellerName(sellers.get(i).getName());
			o.setOrderId(orders.get(i).getOrderId());
			o.setTotalPrice(orders.get(i).getPrice());
			LocalDate today = LocalDate.now();
			Period period = Period.between(today, orders.get(i).getOrderDate());
			if(period.getDays()>30 &&orders.get(i).getStatus().equalsIgnoreCase("DELIVERED"))
			{
				o.setBtnCancel(false);
				o.setBtnReturn(true);
				o.setBtnReviewProduct(true);
				o.setBtnReviewSeller(true);
				
			}
			else {
				o.setBtnCancel(true);
				o.setBtnReturn(false);
				o.setBtnReviewProduct(false);
				o.setBtnReviewSeller(false);
			}
				
			orderDetails.add(o);
		}
		return orderDetails;
		
	}
	
	public String cancelOrder(String userId,int orderId)
	{
		orderRepository.deleteById(orderId); 
		return "deleted";
	}

}
