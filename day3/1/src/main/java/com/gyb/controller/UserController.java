package com.gyb.controller;

import com.gyb.domian.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author gb
 * @Date 2020/7/11 13:28
 * @Version 1.0
 * description:
 */
@Controller
@RequestMapping("user")
public class UserController {
    /**
     * create by: gb
     * description: TODO
     * create time: 2020/7/11 13:29
     *
     * @param model
     * @return
     */
    @RequestMapping("testString")
    public String testString(Model model) {
        System.out.println("testString");
        User user = new User();
        user.setAge(12);
        user.setPassword("123");
        user.setUserName("gyb");
//        model 对象
        model.addAttribute("user", user);


        return "success";
    }


    /**
     * create by: gb
     * description: 测试返回值是空,此时，我们由于没有写返回值，也就是方法执行后的页面名称，当点击response.jsp中的连接时，报错信息就是：
     * Message /1_war/WEB-INF/pages/user/testVoid.jsp
     * 所以，我们可以在pages下添加一个user路径，然后在添加testVoid.jsp，但也有其他的方法
     * create time: 2020/7/11 17:20
     *
     * @param
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        System.out.println("testVoid");
//        请求转发
//        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(httpServletRequest, httpServletResponse);
//        重定向
//        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "index.jsp");
//        设置中文乱码
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("text/html;charset=UTF-8");
//        直接进行响应
        httpServletResponse.getWriter().print("你好");

        return;
    }

    /**
     * create by: gb
     * description: testModelAndView
     * create time: 2020/7/11 18:03
     *
     * @param
     * @return
     */
    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView() {
        System.out.println("testModelAndView");
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        user.setPassword("123");
        user.setAge(12);
        user.setUserName("gyb");
//        把User对象存储到modelAndView中，也会把user对象存入到request对象
        modelAndView.addObject("user", user);
//        跳转到哪个页面
        modelAndView.setViewName("success");
        return modelAndView;
    }

    /**
     * create by: gb
     * description: 使用关键字的方式进行转发或者重定向,这张方式，return必须是forward:+路径
     * 重定向的话，不需要自己添加项目名称（请看64行代码）
     * create time: 2020/7/11 18:22
     *
     * @param
     * @return
     */
    @RequestMapping("testForwardOrRedirect")
    public String testForwardOrRedirect() {
        System.out.println("testForwardOrRedirect");
//        请求转发
//        return "forward:/WEB-INF/pages/success.jsp";
//        重定向
        return "redirect:/index.jsp";
    }

    /**
     * create by: gb
     * description: 模拟异步相应
     *
     * @param
     * @return
     * @ResponseBody把 User转成json
     * create time: 2020/7/12 12:06
     */
    @RequestMapping(value = "testJson")
    @ResponseBody
    public User testJson(@RequestBody User user) {
        System.out.println("testJson");
        System.out.println(user);
        System.out.println(user.getAge());
//        user.setAge(40);
        user.setUserName("hehe");
        user.setPassword("123");
        return user;
    }


}
