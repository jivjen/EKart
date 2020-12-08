package com.infy.ekart.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.infy.ekart.dto.AddCartDTO;
import com.infy.ekart.dto.CartDetails;
import com.infy.ekart.dto.ProductCartDTO;
import com.infy.ekart.dto.ProductDTO;
import com.infy.ekart.dto.SellerDTO;
import com.infy.ekart.entity.CartEntity;
import com.infy.ekart.entity.ProductCartEntity;
import com.infy.ekart.repository.CartRepository;
import com.infy.ekart.repository.ProductCartRepository;

@Service
public class CartService {

	@Autowired
	CartRepository cartRepository;

	@Autowired
	ProductCartRepository productCartRepository;

	@Autowired
	ProductFeign productFeign;

	@Autowired
	SellerFeign sellerFeign;

	@Autowired
	RestTemplate template;

	public CartDetails getCartDetails(String userId) {

		CartEntity userCart = cartRepository.findByUserId(userId);
		List<ProductCartEntity> productCart = productCartRepository.findByCartId(userCart.getCartId());
		List<ProductDTO> products = new ArrayList<>();
		List<SellerDTO> sellers = new ArrayList<>();
		productCart.forEach((cartProduct) -> {
			products.add(productFeign.getProductDetails(cartProduct.getProductId()));
			sellers.add(sellerFeign.getSellerDetails(cartProduct.getProductId()));
		});

		CartDetails cartDetails = new CartDetails();
		cartDetails.setProducts(products);
		cartDetails.setSellers(sellers);
		return cartDetails;

	}

	public String modifyCart(String userId, ProductCartDTO productCartDTO) {
		int cartId = cartRepository.findByUserId(userId).getCartId();
		Optional<ProductCartEntity> l = productCartRepository.findByCartIdAndProductId(cartId,
				productCartDTO.getProductId());
		ProductCartEntity productCartEntity = l.get();
		productCartEntity.setQuantity(productCartDTO.getQuantity());
		productCartEntity.setSellerId(productCartDTO.getSellerId());
		productCartEntity.setCartOfferPrice(productCartDTO.getCartOfferPrice());
		productCartRepository.saveAndFlush(productCartEntity);
		return "Cart updated successfully";
	}

	public List<String> findUserIdbyProductId(int productId) {
		List<String> userIds = new ArrayList<>();
		List<ProductCartDTO> productCartDTOs = productCartRepository.findByProductId(productId);

		if (!productCartDTOs.isEmpty()) {
			for (ProductCartDTO productCartDTO : productCartDTOs) {
				int cartId = productCartDTO.getCartId();
				String userId = cartRepository.findUserIdByCartId(cartId);
				userIds.add(userId);
			}
		}
		return userIds;
	}

	public int getCartItemsCount(String userId) {
		return getCartDetails(userId).getProducts().size();
	}

	public int processCart(String userId, String guestId) {
		CartEntity userCart = cartRepository.findByUserId(userId);
		CartEntity guestCart = cartRepository.findByUserId(guestId);
		if (userCart == null) {

			guestCart.setUserId(userId);
		} else {
			List<ProductCartEntity> productCart = productCartRepository.findByCartId(guestCart.getCartId());
			productCart.forEach((cart) -> {
				cart.setCartId(userCart.getCartId());
			});
			cartRepository.deleteById(guestCart.getCartId());

		}

		return userCart.getCartId();
	}

	public String addToCart(String userId, AddCartDTO addCartDTO) {
		int cartId;
		String guestId = "";
		if (userId.equalsIgnoreCase("GUEST")) {

			LocalDateTime now = LocalDateTime.now();
			String value = "G" + now.getDayOfMonth() + now.getMonthValue() + now.getYear() + now.getHour()
					+ now.getMinute();
			guestId = value;
			CartEntity cart = new CartEntity();
			cart.setUserId(guestId);
			CartEntity savedCart = cartRepository.saveAndFlush(cart);
			cartId = savedCart.getCartId();
		} else {

			CartEntity getCart = cartRepository.findByUserId(userId);

			if (getCart == null) {
				CartEntity cart = new CartEntity();
				cart.setUserId(userId);
				CartEntity savedCart = cartRepository.saveAndFlush(cart);
				cartId = savedCart.getCartId();
			} else {
				cartId = getCart.getCartId();
			}
		}
		String sellerId = template.getForObject("http://EKartSellerMS/" + addCartDTO.getSellerName(), String.class);
		int productId = template.getForObject("http://EKartProductMS/" + addCartDTO.getProductName(), Integer.class);
		Optional<ProductCartEntity> l = productCartRepository.findByCartIdAndProductId(cartId, productId);

		ProductCartEntity productCartEntity = new ProductCartEntity();
		productCartEntity.setCartId(cartId);
		productCartEntity.setCartOfferPrice(0);
		productCartEntity.setProductId(productId);
		productCartEntity.setSellerId(sellerId);
		productCartEntity.setQuantity(addCartDTO.getQuantity());

		productCartRepository.saveAndFlush(productCartEntity);
		if (userId.equalsIgnoreCase("GUEST"))
			return guestId;
		else
			return userId;

	}
}
