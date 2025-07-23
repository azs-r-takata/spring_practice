package com.example.springpractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SelfIntroductionController {
	@GetMapping("/top")
	public String top() {
		return "toppage";
	}
	
	@GetMapping("/hobby")
	public String hobby() {
		return "hobbypage";
	}
	
	@GetMapping("/skills")
	public String skill() {
		return "skillpage";
	}
}
