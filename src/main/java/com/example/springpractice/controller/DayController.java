package com.example.springpractice.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DayController {
	@GetMapping("/day")
	public String day(Model model) {
		DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
		model.addAttribute("week", dayOfWeek);
		return "day";
	}
}
