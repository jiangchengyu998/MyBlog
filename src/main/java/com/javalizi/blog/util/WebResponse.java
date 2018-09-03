package com.javalizi.blog.util;


import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;

public class WebResponse<T> {
    private static final String OK = "ok";
    private static final String ERROR = "error";
    private WebResponse<T>.Meta meta;
    private T data;
    private HttpServletResponse httpServletResponse;

    public WebResponse() {
    }

    public WebResponse(HttpServletResponse httpServletResponse) {
        this.httpServletResponse = httpServletResponse;
    }

    public WebResponse<T> success(T data) {
        this.meta = new WebResponse.Meta(true, HttpStatus.OK.value(), "ok");
        this.data = data;
        return this;
    }

    public WebResponse<T> failure(int statusCode) {
        if (this.httpServletResponse != null) {
            this.httpServletResponse.setStatus(statusCode);
        }

        this.meta = new WebResponse.Meta(false, statusCode, "error");
        return this;
    }

    public WebResponse<T> failure() {
        if (this.httpServletResponse != null) {
            this.httpServletResponse.setStatus(500);
        }

        this.meta = new WebResponse.Meta(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "error");
        return this;
    }

    public WebResponse<T> failure(String message) {
        if (this.httpServletResponse != null) {
            this.httpServletResponse.setStatus(500);
        }

        this.meta = new WebResponse.Meta(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
        return this;
    }

    public WebResponse<T> failure(int statusCode, String message) {
        if (this.httpServletResponse != null) {
            this.httpServletResponse.setStatus(statusCode);
        }

        this.meta = new WebResponse.Meta(false, statusCode, message);
        return this;
    }

    public WebResponse<T> failure(int statusCode, String message, T data) {
        if (this.httpServletResponse != null) {
            this.httpServletResponse.setStatus(statusCode);
        }

        this.meta = new WebResponse.Meta(false, statusCode, message);
        this.setData(data);
        return this;
    }

    public WebResponse<T> noLogin() {
        if (this.httpServletResponse != null) {
            this.httpServletResponse.setStatus(302);
        }

        this.meta = new WebResponse.Meta(false, 302, "未登录或会话已过期，请重新登录！");
        return this;
    }

    public WebResponse<T> noLogin(T data) {
        if (this.httpServletResponse != null) {
            this.httpServletResponse.setStatus(302);
        }

        this.meta = new WebResponse.Meta(false, 302, "未登录或会话已过期，请重新登录！");
        this.setData(data);
        return this;
    }

    public WebResponse<T> unAuthorized() {
        if (this.httpServletResponse != null) {
            this.httpServletResponse.setStatus(401);
        }

        this.meta = new WebResponse.Meta(false, 401, "您正在尝试访问未授权的功能!");
        return this;
    }

    public WebResponse<T>.Meta getMeta() {
        return this.meta;
    }

    public void setMeta(WebResponse<T>.Meta meta) {
        this.meta = meta;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public class Meta {
        private boolean success;
        private int statusCode;
        private String message;

        public Meta() {
        }

        public Meta(boolean success, int statusCode, String message) {
            this.success = success;
            this.statusCode = statusCode;
            this.message = message;
        }

        public boolean isSuccess() {
            return this.success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public int getStatusCode() {
            return this.statusCode;
        }

        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
