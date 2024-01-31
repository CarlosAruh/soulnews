package com.soulcode.soulnews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping({ "/", "/home", "/h" })
	public String paginaHome() {
		return "index";
	}
}