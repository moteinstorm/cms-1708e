package com.e1708.cms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.e1708.cms.common.CmsContant;
import com.e1708.cms.entity.User;
import com.e1708.cms.service.UserService;
import com.zhuzhiguang.cms.utils.StringUtils;

/**
 * 
 * @author zhuzg
 *
 */
@Controller
@RequestMapping("user")
public class UserController {
	
	//public native void test();  .dll
	@Autowired
	UserService userService;
	
	@RequestMapping("home")
	public String home() {
		return "user/home";
	}
	
	/**
	 * 跳转到注册界面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="register",method=RequestMethod.GET)
	public String register(HttpServletRequest request) {
		User user  = new User();
		request.setAttribute("user", user);
		return "user/register";
	}
	
	/**
	 * 从注册页面发过来的请求
	 * @param request
	 * @return
	 */
	@RequestMapping(value="register",method=RequestMethod.POST)
	public String register(HttpServletRequest request,
			@Valid @ModelAttribute("user") User user,
			BindingResult result
			) {
		
		// 有错误返回到注册页面
		if(result.hasErrors()) {
			return "user/register";
		}
		
		//进行唯一性验证
		User existUser = userService.getUserByUsername(user.getUsername());
		if(existUser!=null) {
			result.rejectValue("username", "", "用户名已经存在");
			return "user/register";
		}
				
		//加一个手动的校验
		if(StringUtils.isNumber(user.getPassword())) {
			result.rejectValue("passowrd", "", "密码不能全是数字");
			return "user/register";
		}
		
		// 去注册
		int reRegister = userService.register(user);
		
		//注册失败
		if(reRegister<1) {
			request.setAttribute("eror", "注册失败，请稍后再试！");
			return "user/register";
		}
		
		//跳转到登录页面
		return "redirect:login";
	}
	
	/**
	 * 跳转登录册界面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(HttpServletRequest request) {
		return "user/login";
	}
	
	
	/**
	 * 接受登录界面的请求
	 * @param request
	 * @return
	 */
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(HttpServletRequest request,User user) {
		User loginUser = userService.login(user);
		
		//登录失败
		if(loginUser==null) {
			request.setAttribute("error", "用户名密码错误");
			return "/user/login";	
		}
		
		// 登录成功，用户信息存放看到session当中
		request.getSession().setAttribute(CmsContant.USER_KEY, loginUser);
		
		// 进入管理界面
		if(loginUser.getRole()==CmsContant.USER_ROLE_ADMIN)
			 return "redirect:/admin/index";	
		
		// 进入个人中心
		return "redirect:/user/home";
		
		
		
		
		
	}
	
	
	
	/**
	 * 
	 * @param username
	 * @return
	 */
	@RequestMapping("checkname")
	@ResponseBody
	public boolean checkUserName(String username) {
		User existUser = userService.getUserByUsername(username);
		return existUser==null;
	}
	
	
	@RequestMapping("articles")
	public String articles() {
		return "user/article/list";
	}
	
	@RequestMapping("comments")
	public String comments() {
		return "user/comment/list";
	}
	
	
	
	@RequestMapping("bt")
	public String bt() {
		return "bt/bt";
	}
	
	@RequestMapping("nbt")
	public String nbt() {
		return "bt/nbt";
	}
	
	
	
}
