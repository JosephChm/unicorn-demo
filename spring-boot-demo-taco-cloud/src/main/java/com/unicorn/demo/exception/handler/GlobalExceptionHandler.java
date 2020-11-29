package com.unicorn.demo.exception.handler;

import com.unicorn.demo.domain.Result;
import com.unicorn.demo.exception.CommonException;
import com.unicorn.demo.util.ResultUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ CommonException.class })
    public Result handleAeException(CommonException e) {
        return ResultUtil.genExceptionResult("system error, error message is：" + e.getMessage());
    }

    @ExceptionHandler({ Exception.class })
    public Result handleException(Exception e) {
        return ResultUtil.genExceptionResult("system error, error message is：" + e.getMessage());
    }

    @ExceptionHandler({ RuntimeException.class })
    public Result handleException(RuntimeException e) {
        return ResultUtil.genExceptionResult("system error, error message is：" + e.getMessage());
    }

}
