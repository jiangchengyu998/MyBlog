package com.javalizi.blog.interceptor;

import com.javalizi.blog.pojo.Blogger;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        /**
         *
         */
        Blogger currentUser = (Blogger)request.getSession().getAttribute("currentUser");
        if(currentUser != null){
            // 放行
            return true;
        }
        response.sendRedirect("/blogger/login");
        return false;
    }
}
