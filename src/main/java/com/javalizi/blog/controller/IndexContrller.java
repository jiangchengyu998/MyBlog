package com.javalizi.blog.controller;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.javalizi.blog.pojo.Blog;
import com.javalizi.blog.pojo.BlogType;
import com.javalizi.blog.pojo.Blogger;
import com.javalizi.blog.service.BlogService;
import com.javalizi.blog.service.BlogTypeService;
import com.javalizi.blog.service.BloggerService;
import com.javalizi.blog.util.PageUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Contrller
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
    @Resource
    private BloggerService bloggerService;

	/**
	 * 首页
	 * @return
	 */
	@RequestMapping("/")
	public ModelAndView index(
			            @RequestParam(value="page",required=false,defaultValue = "0")int page, //
                        @RequestParam(value="typeId",required=false)String typeId,
                        @RequestParam(value="releaseDateStr",required=false)String releaseDateStr,
                        HttpServletRequest request){
		Blog b = new Blog();
		if(StringUtil.isNotEmpty(typeId)){
			b.setTypeid(Integer.parseInt(typeId));
		}
		if(StringUtil.isNotEmpty(releaseDateStr)){
			b.setReleaseDateStr(releaseDateStr);
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
        ModelAndView mav=new ModelAndView();
//        Blogger blogger=bloggerService.find(); // 获取博主信息
//        blogger.setPassword(null);
//        List<BlogType> blogTypeCountList = blogTypeService.countList();
//        mav.addObject("blogger", blogger);
        mav.addObject("pageInfo", pageInfo);
//        mav.addObject("blogTypeCountList", blogTypeCountList);
        mav.addObject("mainPage", "blog/list.html");
        mav.addObject("pageCode", PageUtil.genPagination(request.getContextPath()+"/index", pageInfo.getTotal(), page, 8, param.toString()));
        mav.setViewName("index");
        return mav;
	}

	/**
	 * 首页
	 * @return
	 */
	@RequestMapping("/index2")
	public ModelAndView index2(
			@RequestParam(value="page",required=false,defaultValue = "0")int page, //
			@RequestParam(value="typeId",required=false)String typeId,
			@RequestParam(value="releaseDateStr",required=false)String releaseDateStr,
			HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index2");
		return mav;
	}


    /**
     * 源码下载
     * @return
     * @throws Exception
     */
    @RequestMapping("/download")
    public ModelAndView download()throws Exception{
        ModelAndView mav=new ModelAndView();
        Blogger blogger=bloggerService.find(); // 获取博主信息
        blogger.setPassword(null);
        mav.addObject("blogger", blogger);
        List<BlogType> blogTypeCountList = blogTypeService.countList();
        mav.addObject("blogTypeCountList", blogTypeCountList);
        mav.addObject("pageTitle", "本站源码下载页面_java开源博客系统");
        mav.addObject("mainPage", "system/download.html");
        mav.setViewName("index");
        return mav;
    }

}
