package com.sh.api.eshop.shopify.exception;

import com.sh.api.eshop.shopify.exception.util.Results;

public class MyException extends RuntimeException {

    private Integer code;

    public MyException(Results results) {
        super(results.getMessage());

        this.code = results.getCode();
    }

    public MyException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}