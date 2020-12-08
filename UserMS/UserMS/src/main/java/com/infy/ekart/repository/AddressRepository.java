package com.infy.ekart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.ekart.entity.AddressEntity;
import java.util.*;


@Repository
public interface AddressRepository extends JpaRepository<AddressEntity,Integer>{

	List<AddressEntity> findByUserId(String userid);
	
}
