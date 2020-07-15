package com.gyb.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author gb
 * @Date 2020/7/15 11:02
 * @Version 1.0
 * description:异常处理器
 */

public class SystemExceptionResolver implements HandlerExceptionResolver {
    /**
     * create by: gb
     * description: TODO
     * create time: 2020/7/15 11:03
     *
     * @param e
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
//        获取异常对象
        SystemException systemExceptions = null;
        if (e instanceof SystemException) {
            systemExceptions = (SystemException) e;
        } else {
            systemExceptions = new SystemException("正在维护");
        }

//        创建ModelAndView
        ModelAndView modelAndView = new ModelAndView();
//        存入异常信息
        modelAndView.addObject("error", systemExceptions.getMessage());
//        跳转到error
        modelAndView.setViewName("error");


        return modelAndView;
    }
}
