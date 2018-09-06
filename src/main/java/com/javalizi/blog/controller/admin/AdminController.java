package com.javalizi.blog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 这是 视图的转发。
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    /**
     * 转发到写博客的页面。
     * @return
     */
    @RequestMapping("/writeBlog")
    public String main(){
        return "admin/writeBlog";
    }
}
