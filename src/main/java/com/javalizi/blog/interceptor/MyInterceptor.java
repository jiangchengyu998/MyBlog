package com.javalizi.blog.interceptor;

import com.javalizi.blog.pojo.Blogger;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        /**
         * 在这里判断是否登录
         */
        Blogger currentUser = (Blogger)request.getSession().getAttribute("currentUser");
        if(currentUser != null){
            // 登录了，放行
            return true;
        }
        // 没有登录，重定向到登录页面。
        response.sendRedirect("/blogger/login");
        return false;
    }
}
