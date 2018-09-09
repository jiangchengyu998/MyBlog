package com.javalizi.blog.controller.admin;

import com.javalizi.blog.pojo.Blog;
import com.javalizi.blog.pojo.BlogType;
import com.javalizi.blog.pojo.Blogger;
import com.javalizi.blog.pojo.Link;
import com.javalizi.blog.pojo.LinkExample;
import com.javalizi.blog.service.BlogService;
import com.javalizi.blog.service.BlogTypeService;
import com.javalizi.blog.service.BloggerService;
import com.javalizi.blog.service.LinkService;
import com.javalizi.blog.util.ResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/admin/system")
public class SystemAdminController {

	@Resource
	private BloggerService bloggerService;
	
	@Resource
	private LinkService linkService;
	
	@Resource
	private BlogTypeService blogTypeService;
	
	@Resource
	private BlogService blogService;
	@Autowired
	private ServletContext context;

	/**
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/refreshSystem")
	public String refreshSystem(HttpServletResponse response)throws Exception{
		System.out.println("刷新緩存 .....");
		Blogger blogger=bloggerService.find(); //
		blogger.setPassword(null);
		context.setAttribute("blogger", blogger);
		List<BlogType> blogTypeCountList = blogTypeService.countList();
		context.setAttribute("blogTypeCountList", blogTypeCountList);
		List<Link> linkList = linkService.list(new LinkExample());
		context.setAttribute("linkList", linkList);
		List<Blog> blogCountList = blogService.countList();
		context.setAttribute("blogCountList", blogCountList);
		System.out.println("刷新緩存 成功.....");

		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
}
