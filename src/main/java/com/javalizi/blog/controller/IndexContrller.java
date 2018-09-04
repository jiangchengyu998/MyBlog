package com.javalizi.blog.controller;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.javalizi.blog.pojo.Blog;
import com.javalizi.blog.pojo.BlogType;
import com.javalizi.blog.service.BlogService;
import com.javalizi.blog.service.BlogTypeService;
import com.javalizi.blog.util.PageUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 主页Contrller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/")
public class IndexContrller {

	@Resource
	private BlogService blogService;
	@Resource
	private BlogTypeService blogTypeService;
	
	/**
	 * 请求主页
	 * @return
	 */
	@RequestMapping("/index")
	public String index(
			            @RequestParam(value="page",required=false,defaultValue = "0")int page, // 当前页
                        @RequestParam(value="typeId",required=false)String typeId,
                        @RequestParam(value="releaseDateStr",required=false)String releaseDateStr,
                        HttpServletRequest request){
		Blog b = new Blog();
		if(StringUtil.isNotEmpty(typeId)){
			b.setTypeid(Integer.parseInt(typeId));
		}
		PageInfo<Blog> pageInfo = blogService.selectByPage(b, page, 8);
		for(Blog blog:pageInfo.getList()){
			List<String> imageList=blog.getImageList();
			String blogInfo=blog.getContent();
			Document doc= Jsoup.parse(blogInfo);
			Elements jpgs=doc.select("img[src$=.jpg]");
			for(int i=0;i<jpgs.size();i++){
				Element jpg=jpgs.get(i);
				imageList.add(jpg.toString());
				if(i==2){
					break;
				}
			}
		}
		StringBuffer param=new StringBuffer();
		if(StringUtil.isNotEmpty(typeId)){
			param.append("typeId="+typeId+"&");
		}
		if(StringUtil.isNotEmpty(releaseDateStr)){
			param.append("releaseDateStr="+releaseDateStr+"&");
		}
		request.setAttribute("pageInfo", pageInfo);
		List<BlogType> blogTypeCountList = blogTypeService.countList();
        request.setAttribute("blogTypeCountList", blogTypeCountList);
        request.setAttribute("mainPage", "blog/list.html");
		request.setAttribute("pageCode", PageUtil.genPagination(request.getContextPath()+"/index", pageInfo.getTotal(), page, 8, param.toString()));
		return "index";
	}

}
