package com.gyb.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author gb
 * @Date 2020/7/15 12:00
 * @Version 1.0
 * description:
 */

public class Interceptor implements HandlerInterceptor {
    /**
     * create by: gb
     * description: 预处理，controller执行前运行
     * 如果return true，执行下一个拦截器，如果没有，执行controller中的方法
     * 如果return false，不放行，
     * create time: 2020/7/15 12:01
     *
     * @param request
     * @param handler
     * @param response
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器执行");
//        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);


        return true;
    }

    /**
     * create by: gb
     * description: controller执行后运行的方法
     * create time: 2020/7/15 12:13
     *
     * @param handler
     * @param modelAndView
     * @param request
     * @param response
     * @return
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle执行");

    }

    /**
     * create by: gb
     * description: 会在controller执行后跳转到success之后再执行
     * create time: 2020/7/15 12:17
     *
     * @param response
     * @param handler
     * @param request
     * @param ex
     * @return
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        System.out.println("最后");

    }
}
