package com.javalizi.blog.controller.admin;

import com.github.pagehelper.PageInfo;
import com.javalizi.blog.pojo.BlogType;
import com.javalizi.blog.service.BlogService;
import com.javalizi.blog.service.BlogTypeService;
import com.javalizi.blog.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * 管理员博客类别Controller层
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/admin/blogType")
public class BlogTypeAdminController {

	@Resource
	private BlogTypeService blogTypeService;
	
	@Resource
	private BlogService blogService;
	
	/**
	 * 分页查询博客类别信息
	 * @param page
	 * @param rows
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="page",required=false)int page
			, @RequestParam(value="rows",required=false)int rows
			, HttpServletResponse response)throws Exception{
		BlogType blogType = new BlogType();
		PageInfo<BlogType> pageInfo = blogTypeService.selectByPage(blogType, page, rows);
		JSONObject result=new JSONObject();
		JSONArray jsonArray=JSONArray.fromObject(pageInfo.getList());
		result.put("rows", jsonArray);
		result.put("total", pageInfo.getTotal());
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 添加或者修改博客类别信息
	 * @param blogType
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(BlogType blogType, HttpServletResponse response)throws Exception{
		int resultTotal=0; 
		if(blogType.getId()==null){
			resultTotal=blogTypeService.add(blogType);
		}else{
			resultTotal=blogTypeService.update(blogType);
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
	 * 博客类别信息删除
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="ids",required=false)String ids, HttpServletResponse response)throws Exception{
		JSONObject result=new JSONObject();

		Integer delete = blogTypeService.delete(ids,result);
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
}
