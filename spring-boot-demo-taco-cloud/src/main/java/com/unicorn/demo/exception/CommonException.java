package com.unicorn.demo.exception;

public class CommonException extends RuntimeException {

    private String msg;
    private String code;

    public CommonException(String msg) {
        super(msg);
        this.msg = msg;
        code = ResultCode.EXCEPTION_ERROR.code();
    }

    public CommonException(String msg, Throwable cause) {
        super(msg, cause);
        this.msg = msg;
        code = ResultCode.EXCEPTION_ERROR.code();
    }

    public CommonException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public CommonException(String code, String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
