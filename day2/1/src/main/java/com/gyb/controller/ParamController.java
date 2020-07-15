package com.gyb.controller;

import com.gyb.domain.Account;
import com.gyb.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author gb
 * @Date 2020/7/7 14:45
 * @Version 1.0
 * description:paramController
 */
@Controller
@RequestMapping("/param")
public class ParamController {

    /**
     * create by: gb
     * description: 请求参数绑定入门方法
     * create time: 2020/7/7 14:47
     *
     * @param
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping(value = "testParam")
    public String testParam(String userName, String password) {
        System.out.println("请求参数绑定");
        System.out.println("用户名" + userName);
        System.out.println("密码" + password);
        return "testParam";
    }

    /**
     * create by: gb
     * description: 保存账户，用来测试param.jsp中的表单
     * create time: 2020/7/7 15:03
     *
     * @param account
     * @return
     */
    @RequestMapping(value = "saveAccount")
    public String saveAccount(Account account) {
        System.out.println(account);
        return "testParam";
    }
    /**
     * create by: gb
     * description:自定义类型转换器
     * create time: 2020/7/8 17:00
     * @param user
     * @return
     */
    @RequestMapping(value = "saveUser")
    public String saveUser(User user){
        System.out.println(user);
        return "testParam";

    }
    /**
     * create by: gb
     * description: 获取原生Servlet,如果想获取原生的API，只需要在参数上添加就可以
     * create time: 2020/7/9 13:20
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     */
    @RequestMapping(value= "testServlet")
    public String testServlet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        System.out.println("执行了testServlet");
        System.out.println(httpServletRequest);
        System.out.println(httpServletResponse);
        HttpSession session = httpServletRequest.getSession();
        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);
        return "testParam";
    }

}
