package com.infy.ekart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.infy.ekart.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
	@Query(value = "select * from ecart_order_details.order abc where abc.user_id = ?1",nativeQuery = true)
	List<OrderEntity> findOrders(String userId);

	@Query(value = "select * from ecart_order_details.order abc where abc.user_id = ?1",nativeQuery = true)
	List<OrderEntity> findByUserId(String userId);
}
