package com.example.springpractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NumberListController {
	@GetMapping("/numbers")
	public String practice() {
		return "numberList";
	}
}
