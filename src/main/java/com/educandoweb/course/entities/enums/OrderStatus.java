package com.educandoweb.course.entities.enums;

public enum OrderStatus {
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	/** It is the code of the the ENUM values */
	private int code;
	
	/** The ENUM constructor is private! */
	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	/** Converts a numeric value to ENUM value 
	 * It is static cause we won't need it to be instantiated 
	 * Basically you will give a code and this method will return you a OrderStatus value (enum) 
	 */
	public static OrderStatus valueOf(int code) {
		// Search one-by-one enum value if the code exists in the enum class
		for(OrderStatus value : OrderStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code!");
	}
}
