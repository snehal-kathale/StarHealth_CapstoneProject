package com.sh.api.eshop.shopify.common;

public class ApiResponse {
	private final boolean success;
	private final String message;
	// try again
	
	public ApiResponse(boolean success, String message) {
		this.success = success;
		this.message = message;
	}


}
