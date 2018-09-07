package com.javalizi.blog.controller.admin;

import com.github.pagehelper.PageInfo;
import com.javalizi.blog.pojo.Comment;
import com.javalizi.blog.service.CommentService;
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
 * 管理员评论Controller层
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/admin/comment")
public class CommentAdminController {

	@Resource
	private CommentService commentService;
	
	/**
	 * 分页查询评论信息
	 * @param page
	 * @param rows
	 * @param state
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="page",required=false)int page, @RequestParam(value="rows",required=false)int rows,
					   @RequestParam(value="state",required=false)String state, HttpServletResponse response)throws Exception{
		Comment comment = new Comment();
		comment.setState(Integer.parseInt(state));
		PageInfo<Comment> pageInfo = commentService.selectByPage(comment, page, rows);
		JSONObject result=new JSONObject();
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray=JSONArray.fromObject(pageInfo.getList(), jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", pageInfo.getTotal());
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 评论审核
	 * @param ids
	 * @param state
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/review")
	public String review(@RequestParam(value="ids",required=false)String ids, @RequestParam(value="state",required=false)Integer state, HttpServletResponse response)throws Exception{
		commentService.update(ids,state);
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 评论信息删除
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="ids",required=false)String ids, HttpServletResponse response)throws Exception{
		String []idsStr=ids.split(",");
		JSONObject result=new JSONObject();
		for(int i=0;i<idsStr.length;i++){
			commentService.delete(Integer.parseInt(idsStr[i]));				
		}
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
}
