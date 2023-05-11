package com.lch.socketdemo.handler;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {

    /**
     *预处理方法
     * 参数：
     *      request
     *      response
     *      handler：被拦截的控制器对象
     * 返回值：
     *      boolean
     * 特点：  1.方法在控制器方法之前先执行的，用户的请求首先到达此方法
     *        2.在这个方法可以获取请求的信息，验证请求是否符合要求
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("拦截器MyInterceptor的preHandle()");
        //验证登录的用户信息
//        Object attr = request.getSession().getAttribute("name");
//        if(attr == null){
//            request.getRequestDispatcher("/WEB-INF/jsp/tips.jsp").forward(request, response);
//            return false;
//        }

//        String logName = "";
//        logName = (String)attr;
//        if(!"zs".equals(logName)){
//            request.getRequestDispatcher("/WEB-INF/jsp/tips.jsp").forward(request, response);
//            return false;
//        }
        return true;
    }
}
