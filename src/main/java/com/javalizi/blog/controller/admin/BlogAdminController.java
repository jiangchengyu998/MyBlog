package com.javalizi.blog.controller.admin;

import com.github.pagehelper.PageInfo;
import com.javalizi.blog.pojo.Blog;
import com.javalizi.blog.service.BlogService;
import com.javalizi.blog.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * 管理员博客Controller层
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/admin/blog")
public class BlogAdminController {

	@Resource
	private BlogService blogService;
	

	/**
	 * 添加或者修改博客信息
	 * @param blog
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(Blog blog, HttpServletResponse response)throws Exception{
		int resultTotal=0; 
		if(blog.getId()==null){
			resultTotal=blogService.add(blog);
		}else{
			resultTotal=blogService.update(blog);
		}
		JSONObject result=new JSONObject();
		if(resultTotal>0){
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 分页查询博客信息
	 * @param page
	 * @param rows
	 * @param s_blog
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="page",required=false)int page, @RequestParam(value="rows",required=false)int rows,
					   Blog s_blog, HttpServletResponse response)throws Exception{
		PageInfo<Blog> pageInfo = blogService.selectByPage(s_blog, page, rows);
		JSONObject result=new JSONObject();
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray=JSONArray.fromObject(pageInfo.getList(),jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", pageInfo.getTotal());
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 博客信息删除
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="ids",required=false)String ids, HttpServletResponse response)throws Exception{
		Integer delete = blogService.delete(ids);
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 通过Id查找实体
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findById")
	public String findById(@RequestParam(value="id")String id, HttpServletResponse response)throws Exception{
		Blog blog=blogService.findById(Integer.parseInt(id));
		JSONObject result=JSONObject.fromObject(blog);
		ResponseUtil.write(response, result);
		return null;
	}
}
