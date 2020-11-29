package com.unicorn.demo.util;

import com.unicorn.demo.domain.DateResult;
import com.unicorn.demo.domain.Result;
import com.unicorn.demo.exception.ResultCode;

public class ResultUtil {

    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static Result genSuccessResult() {
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS.code());
        result.setMsg(DEFAULT_SUCCESS_MESSAGE);
        return result;
    }

    public static <T> DateResult<T> genSuccessResult(T data) {
        DateResult<T> dateResult = new DateResult<T>();
        dateResult.setCode(ResultCode.SUCCESS.code());
        dateResult.setMsg(DEFAULT_SUCCESS_MESSAGE);
        dateResult.setResult(data);
        return dateResult;
    }

    public static Result genExceptionResult(String msg) {
        Result result = new Result();
        result.setCode(ResultCode.EXCEPTION_ERROR.code());
        result.setMsg(msg);
        return result;
    }

}
