package com.demo.creditcardapplication.api.exception;

public class UserNotEligibleForCreditCard extends RuntimeException {
	
	public UserNotEligibleForCreditCard(String message) {
		super(message);
	}

}
