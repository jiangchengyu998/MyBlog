package com.javalizi.blog.controller;

import com.javalizi.blog.pojo.Blogger;
import com.javalizi.blog.service.BloggerService;
import com.javalizi.blog.util.CryptographyUtil;
import com.javalizi.blog.util.StringUtil;
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

	@RequestMapping("/main")
	public String main(){
		return "main";
	}

	@RequestMapping("/login")
	public ModelAndView login(Blogger blogger, HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		if(blogger != null && StringUtil.isNotEmpty(blogger.getUsername())
				&& StringUtil.isNotEmpty(blogger.getPassword())){
			blogger.setPassword(CryptographyUtil.md5(blogger.getPassword(),""));
			Blogger blogger1 = bloggerService.find(blogger);
			if(blogger1 != null){
				blogger1.setPassword("");
				request.getSession().setAttribute("currentUser",blogger1);
				mav.setViewName("redirect:main");
			}else {
				mav.addObject("errorInfo", "用户名或者密码错误！");
				mav.addObject("blogger", blogger);
				mav.setViewName("login");
			}
		}else {
			mav.addObject("blogger", blogger);
			mav.setViewName("login");
		}
		return mav;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/aboutMe")
	public ModelAndView aboutMe()throws Exception{
		ModelAndView mav=new ModelAndView();

		mav.addObject("pageTitle", "关于博主_java开源博客系统");
		mav.addObject("mainPage", "blogger/info.html");
		mav.setViewName("index");
		return mav;
	}
}
