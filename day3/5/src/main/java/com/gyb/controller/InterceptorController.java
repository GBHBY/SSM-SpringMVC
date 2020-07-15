package com.gyb.controller;

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
public class InterceptorController {

    /**
     * create by: gb
     * description: 拦截求
     * create time: 2020/7/15 11:53
     *
     * @param
     * @return
     */
    @RequestMapping(value = "testInterceptor")
    public String testInterceptor() {
        System.out.println("controller");

        return "success";
    }


}
