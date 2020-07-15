package com.gyb.controller;

import com.gyb.exception.SystemException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author gb
 * @Date 2020/7/15 10:49
 * @Version 1.0
 * description:异常处理
 */
@RequestMapping(value = "user")
@Controller
public class ExceptionController {
    /**
     * create by: gb
     * description: TODO
     * create time: 2020/7/15 10:50
     *
     * @param
     * @return
     */
    @RequestMapping(value = "testException")
    public String testException() throws SystemException {
        System.out.println("testException");

        try {
            int i = 1/0;
        } catch (Exception e) {
//            打印异常信息
            e.printStackTrace();
//            抛出自定义异常
            throw new SystemException("出现错误");
        }

        return "success";
    }
}
