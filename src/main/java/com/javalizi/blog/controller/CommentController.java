package com.javalizi.blog.controller;

import com.javalizi.blog.pojo.Comment;
import com.javalizi.blog.service.CommentService;
import com.javalizi.blog.util.ResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 *
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

	@Resource
	private CommentService commentService;

	/**
	 * @param comment
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(Comment comment, HttpServletRequest request,
					   HttpServletResponse response) throws Exception {
		JSONObject result=new JSONObject();
		int resultTotal=0;
		String userIp=request.getRemoteAddr(); // 获取ip
		comment.setUserip(userIp);
		comment.setCommentdate(new Date());
		if(comment.getId()==null){
			try {
				resultTotal=commentService.add(comment);
			} catch (Exception e) {
				result.put("success", false);
				result.put("errorInfo", "出错了！");
				ResponseUtil.write(response, result);
				e.printStackTrace();
			}
		}
		if(resultTotal>0){
			result.put("success", true);
		}else{
			result.put("success", false);
			result.put("errorInfo", "出错了！");
		}
		ResponseUtil.write(response, result);
		return null;
	}
}
