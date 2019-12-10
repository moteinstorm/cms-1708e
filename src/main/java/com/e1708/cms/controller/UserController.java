package com.e1708.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author zhuzg
 *
 */
@Controller
@RequestMapping("user")
public class UserController {
	
	//public native void test();  .dll
	
	@RequestMapping("home")
	public String home() {
		return "user/home";
	}
	
	@RequestMapping("register")
	public String register() {
		return "user/register";
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
