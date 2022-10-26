package com.sh.api.eshop.shopify.exception.util;

import lombok.Getter;

@Getter
public enum Results {

    PARAM_ERROR(1, "Parameter Error!"),
    PRODUCT_NOT_EXIST(10, "Product does not exit!"),
    PRODUCT_NOT_ENOUGH(11, "Not enough products in stock!"),

    CART_CHECKOUT_SUCCESS(20, "Checkout successfully! "),

    CATEGORY_NOT_FOUND(30, "Category does not exit!"),

    VALID_ERROR(50, "Wrong information"),
    USER_NOT_FOUNT(40,"User is not found!")
    ;


    private Integer code;
    private String message;

    Results(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}

