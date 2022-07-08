package com.common.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Boolean identity = (Boolean) request.getSession().getAttribute("identity");
        if (identity == null) {
            response.setStatus(401);
            return false;
        }
        return true;
    }
}
