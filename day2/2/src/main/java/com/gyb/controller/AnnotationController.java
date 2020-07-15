package com.gyb.controller;

import com.gyb.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

/**
 * @Author gb
 * @Date 2020/7/9 15:05
 * @Version 1.0
 * description:注解
 * 相当于把msg==妹妹存入session域中
 */
@RequestMapping(value = "annotation")
@Controller
@SessionAttributes(value = {"msg"})
public class AnnotationController {

    /**
     * create by: gb
     * description: 添加了@RequestParam注解，注解中的name属性赋值为连接中要传的属性名，这样方法参数中的name就会得到连接中的username值
     * create time: 2020/7/9 15:06
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "testRequestParam")
    public String testRequestParam(@RequestParam(name = "username") String name) {
        System.out.println("执行了testRequestParam");
        System.out.println(name);
        return "testAnnotation";
    }

    /**
     * create by: gb
     * description: testRequestBody,获取到请求体的内容
     * create time: 2020/7/9 15:33
     *
     * @param body
     * @return
     */
    @RequestMapping(value = "testRequestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println(body);
        return "testAnnotation";

    }


    /**
     * create by: gb
     * description:testRequestHeader
     * create time: 2020/7/11 11:15
     *
     * @param header
     * @return
     */
    @RequestMapping("testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String header) {
        System.out.println(header);
        return "testAnnotation";


    }

    /**
     * create by: gb
     * description: 获得cookie
     * create time: 2020/7/11 11:27
     *
     * @param cookieValue
     * @return
     */
    @RequestMapping(value = "testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue) {
        System.out.println(cookieValue);
        return "testAnnotation";
    }

    /**
     * create by: gb
     * description:ModelAttribute注解放在方法上,如果前台提交的表单的数据只有name和age，但我们需要返回一个完整的User，我们可以使用ModelAttribute这个注解
     * modelAttribute通过得到的userName从数据库中查询数据，并进行返回全部数据
     * create time: 2020/7/11 11:32
     *
     * @param user
     * @return
     */
    @RequestMapping("testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User user) {
        System.out.println("testModelAttribute执行");
        System.out.println(user);
        return "testAnnotation";
    }

    /**
     * create by: gb
     * description: 这种方式需要返回值
     * create time: 2020/7/11 12:28
     *
     * @param
     * @return
     */
    @ModelAttribute
    public User modelAttribute() {
        System.out.println("modelAttribute执行");
        User user = new User();
        user.setDate(new Date());
        return user;
    }


    /**
     * create by: gb
     * description: 通过Map来储存，这样就不需要返回值了,但需要在testModelAttribute方法上添加@ModelAttribute注解
     * create time: 2020/7/11 12:22
     *
     * @param userName
     * @param age
     * @param map
     * @return
     */
    @ModelAttribute
    public void modelAttributeByMap(String userName, Integer age, Map<String, User> map) {
        System.out.println("modelAttributeByMap");
        User user = new User();
        user.setUserName(userName);
        user.setAge(age);
        user.setDate(new Date());
        map.put("abc", user);
    }

    /**
     * create by: gb
     * description: TODO
     * create time: 2020/7/11 12:30
     *
     * @param model
     * @return
     */
    @RequestMapping("testSessionAttributes")
    public String testSessionAttributes(Model model) {
        System.out.println("testSessionAttributes");
        model.addAttribute("msg", "妹妹");
        return "testAnnotation";
    }

    /**
     * create by: gb
     * description: TODO
     * create time: 2020/7/11 12:30
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("testGetSessionAttributes")
    public String testGetSessionAttributes(ModelMap modelMap) {
        System.out.println("testSessionAttributes");
        String msg = (String) modelMap.get("msg");
        System.out.println(msg);
        return "testAnnotation";
    }




}
