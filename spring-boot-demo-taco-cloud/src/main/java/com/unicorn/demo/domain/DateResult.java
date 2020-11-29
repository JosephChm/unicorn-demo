package com.unicorn.demo.domain;

import java.io.Serializable;

public class DateResult<T> extends Result implements Serializable {

    private T result;

    public T getResult() {
        return (T) result;
    }

    public void setResult(T result) {
        this.result = result;
    }

}
