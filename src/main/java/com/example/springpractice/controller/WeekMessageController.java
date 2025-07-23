package com.example.springpractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeekMessageController {
	@GetMapping("/monday")
	public String monday() {
		return "mondyMessage";
	}
	
	@GetMapping("/tuesday")
	public String tuesday() {
		return "tuesdayMessage";
	}
	
	@GetMapping("/wednesday")
	public String wednesday() {
		return "wednesdayMessage";
	}
	
	@GetMapping("/thursday")
	public String thursday() {
		return "thursdayMessage";
	}
	
	@GetMapping("/friday")
	public String friday() {
		return "fridayMessage";
	}
}
