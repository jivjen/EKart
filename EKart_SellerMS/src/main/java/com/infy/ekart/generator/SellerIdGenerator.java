package com.infy.ekart.generator;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class SellerIdGenerator implements IdentifierGenerator {
	private static int counter = 1001;

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		int id = counter++;
		LocalDateTime now = LocalDateTime.now();
		String value = "S" + now.getDayOfMonth() + now.getMonthValue() + now.getYear() + now.getHour()
				+ now.getMinute();
		return value + id;
	}

}

