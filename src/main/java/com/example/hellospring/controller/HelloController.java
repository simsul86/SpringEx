package com.example.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	/**
	 * 첫번째 기본 test  
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("hello")
	public String hello(Model model) throws Exception {
		
		model.addAttribute("data", "hello!!");
		
		return "hello";
	}
	
	/**
	 * MVC 방식 : 랜더링(view resolver) 후 화면에 뿌리기.
	 * 
	 * @param name
	 * @param model
	 * @return
	 */
	@GetMapping("hello-mvc")
	public String helloMvc(@RequestParam(name = "name", required = false) String name, Model model) throws Exception {
		
		model.addAttribute("name", name);
		
		return "hello-template";
	}
	
	/**
	 * api 방식1
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	@GetMapping("hello-string")
	@ResponseBody
	public String helloString(@RequestParam("name") String name) throws Exception {
		
		return "hello " + name;
	}
	
	/**
	 * api 방식2
	 * 기초적, 기본적인 api 방식이라고 함.
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	@GetMapping("hello-api")
	@ResponseBody
	public Hello helloApi(@RequestParam("name") String name) throws Exception {
		
		Hello hello = new Hello();
		
		hello.setName(name);
		
		return hello;
	}
	
	/**
	 * static 클래스
	 * 
	 * @author Park
	 */
	static class Hello {
		
		/**
		 * name
		 */
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}