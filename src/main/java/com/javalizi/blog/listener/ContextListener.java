package com.javalizi.blog.listener;

import com.javalizi.blog.pojo.*;
import com.javalizi.blog.service.BlogService;
import com.javalizi.blog.service.BlogTypeService;
import com.javalizi.blog.service.BloggerService;
import com.javalizi.blog.service.LinkService;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

@WebListener
public class ContextListener implements ServletContextListener {

    @Resource
    private BloggerService bloggerService;
    @Resource
    private BlogTypeService blogTypeService;
    @Resource
    private LinkService linkService;
    @Resource
    private BlogService blogService;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("把博主信息和博客类型放在session.....");
        ServletContext context = servletContextEvent.getServletContext();
        Blogger blogger=bloggerService.find(); // 获取博主信息
        blogger.setPassword(null);
        context.setAttribute("blogger", blogger);
        List<BlogType> blogTypeCountList = blogTypeService.countList();
        context.setAttribute("blogTypeCountList", blogTypeCountList);
        List<Link> linkList = linkService.list(new LinkExample());
        context.setAttribute("linkList", linkList);
        List<Blog> blogCountList = blogService.countList();
        context.setAttribute("blogCountList", blogCountList);
        System.out.println("把博主信息和博客类型放在session 完毕.....");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
