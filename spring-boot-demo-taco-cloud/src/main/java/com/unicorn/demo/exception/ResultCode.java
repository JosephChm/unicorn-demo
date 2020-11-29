package com.unicorn.demo.exception;

public enum ResultCode {

    SUCCESS("200"), //success
    FAIL("400"), //failure
    UNAUTHORIZED("401"), //unauthorized
    NOT_FOUND("404"), //api not found
    INTERNAL_SERVER_ERROR("500"), //internal server error
    EXCEPTION_ERROR("-1");//global error

    private final String code;

    ResultCode(String code) {
        this.code = code;
    }

    public String code() {
        return code;
    }

}
