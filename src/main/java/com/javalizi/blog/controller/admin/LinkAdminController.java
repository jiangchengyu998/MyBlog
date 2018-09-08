package com.javalizi.blog.controller.admin;

import com.github.pagehelper.PageInfo;
import com.javalizi.blog.pojo.Link;
import com.javalizi.blog.pojo.PageBean;
import com.javalizi.blog.service.LinkService;
import com.javalizi.blog.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理员友情链接Controller层
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/admin/link")
public class LinkAdminController {

	@Resource
	private LinkService linkService;
	
	
	/**
	 * 分页查询友情链接信息
	 * @param page
	 * @param rows
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="page",required=false)int page,
					   @RequestParam(value="rows",required=false)int rows, HttpServletResponse response)throws Exception{
		Link link = new Link();
		PageInfo<Link> pageInfo = linkService.selectByPage(link, page, rows);
		JSONObject result=new JSONObject();
		JSONArray jsonArray=JSONArray.fromObject(pageInfo.getList());
		result.put("rows", jsonArray);
		result.put("total", pageInfo.getTotal());
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 添加或者修改友情链接信息
	 * @param link
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(Link link,HttpServletResponse response)throws Exception{
		int resultTotal=0; 
		if(link.getId()==null){
			resultTotal=linkService.add(link);
		}else{
			resultTotal=linkService.update(link);
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
	 * 友情链接信息删除
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="ids",required=false)String ids, HttpServletResponse response)throws Exception{
		JSONObject result=new JSONObject();
		linkService.delete(ids);
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
}
