package com.gyb.exception;

/**
 * @Author gb
 * @Date 2020/7/15 10:58
 * @Version 1.0
 * description:自自定义异常类
 */

public class SystemException extends  Exception {
    private String message;

    public SystemException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
