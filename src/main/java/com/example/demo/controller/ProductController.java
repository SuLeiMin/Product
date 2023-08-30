package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.productService;

@Controller
public class ProductController {

	@Autowired
    private productService pService;
	
	@GetMapping("/")
    public String menu() {
       
        return "menu";
    }
	
	@GetMapping("/ichiran")
    public String viewichiran(Model model) {
        model.addAttribute("product", pService.getAllProduct());
        return "ichiran";
    }
	
	@GetMapping("/menu")
    public String backmenu() {
       
        return "menu";
    }
}
