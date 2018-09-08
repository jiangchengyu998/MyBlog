package com.javalizi.blog.controller.admin;

import com.javalizi.blog.pojo.Blogger;
import com.javalizi.blog.service.BloggerService;
import com.javalizi.blog.util.CryptographyUtil;
import com.javalizi.blog.util.DateUtil;
import com.javalizi.blog.util.ResponseUtil;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/admin/blogger")
public class BloggerAdminController {

	@Resource
	private BloggerService bloggerService;
	
	/**
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/find")
	public String find(HttpServletResponse response)throws Exception{
		Blogger blogger=bloggerService.find();
		JSONObject jsonObject=JSONObject.fromObject(blogger);
		ResponseUtil.write(response, jsonObject);
		return null;
	}
	
	/**
	 * @param imageFile
	 * @param blogger
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(@RequestParam("imageFile") MultipartFile imageFile, Blogger blogger, HttpServletRequest request, HttpServletResponse response)throws Exception{
		if(!imageFile.isEmpty()){
			String filePath=request.getServletContext().getRealPath("/");
			String imageName= DateUtil.getCurrentDateStr()+"."+imageFile.getOriginalFilename().split("\\.")[1];
			imageFile.transferTo(new File(filePath+"static/userImages/"+imageName));
			blogger.setImagename(imageName);
		}
		int resultTotal=bloggerService.update(blogger);
		StringBuffer result=new StringBuffer();
		if(resultTotal>0){
			result.append("<script language='javascript'>alert('成功');</script>");
		}else{
			result.append("<script language='javascript'>alert('失败');</script>");
		}
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * @param newPassword
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/modifyPassword")
	public String modifyPassword(String newPassword, HttpServletResponse response)throws Exception{
		Blogger blogger=new Blogger();
		blogger.setPassword(CryptographyUtil.md5(newPassword,"java1234"));
		int resultTotal=bloggerService.update(blogger);
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
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/logout")
	public String logout()throws Exception{
		SecurityUtils.getSubject().logout(); 
		return "redirect:/login.jsp";
	}
}
