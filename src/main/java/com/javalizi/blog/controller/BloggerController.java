package com.javalizi.blog.controller;

import com.javalizi.blog.pojo.Blogger;
import com.javalizi.blog.service.BlogTypeService;
import com.javalizi.blog.service.BloggerService;
import com.javalizi.blog.util.CryptographyUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/blogger")
public class BloggerController {

	@Resource
	private BloggerService bloggerService;
	@Resource
	private BlogTypeService blogTypeService;
	
	@RequestMapping("/login")
	public String login(Blogger blogger, HttpServletRequest request){
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(blogger.getUsername(), CryptographyUtil.md5(blogger.getPassword(), "java1234"));
		try{
			subject.login(token); //
			return "redirect:/admin/main.jsp";
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("blogger", blogger);
			request.setAttribute("errorInfo", "错误");
			return "login";
		}
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/aboutMe")
	public ModelAndView aboutMe()throws Exception{
		ModelAndView mav=new ModelAndView();

//		Blogger blogger=bloggerService.find(); // 获取博主信息
//		blogger.setPassword(null);
//		mav.addObject("blogger", blogger);
//		List<BlogType> blogTypeCountList = blogTypeService.countList();
//		mav.addObject("blogTypeCountList", blogTypeCountList);
		mav.addObject("pageTitle", "关于博主_java开源博客系统");
		mav.addObject("mainPage", "blogger/info.html");
		mav.setViewName("index");
		return mav;
	}
}
