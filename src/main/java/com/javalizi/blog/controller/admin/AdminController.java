package com.javalizi.blog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

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
    public String writeBlog(){
        return "admin/writeBlog";
    }

    /**
     * 转发到博客管理页面
     * @return
     */
    @RequestMapping("/blogManage")
    public String blogManage(){
        return "admin/blogManage";
    }

    /**
     * 转发到修改博客页面
     * @return
     */
    @RequestMapping("/modifyBlog")
    public String modifyBlog(int id, HttpServletRequest request){
        request.setAttribute("id",id);
        return "admin/modifyBlog";
    }

    /**
     * 转发到审核页面
     * @return
     */
    @RequestMapping("/commentReview")
    public String modifyBlog(){
        return "admin/commentReview";
    }
}
