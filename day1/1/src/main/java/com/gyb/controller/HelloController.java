package com.gyb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author gb
 * @Date 2020/7/6 15:26
 * @Version 1.0
 * description:控制器
 */
@Controller
public class HelloController {
    
    /**
     * create by: gb
     * description:
     *  /hello就是这个方法的请求路径
     * create time: 2020/7/6 15:27
     * @param 
     * @return null
     */

    @RequestMapping(path = "/hello",method = {RequestMethod.POST})
    public String sayHello(){
        System.out.println("啦啦啦");
        return "success";
    }
}
