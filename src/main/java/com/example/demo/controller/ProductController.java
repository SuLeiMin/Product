package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookStore.bookStore.entity.Book;
import com.example.demo.entity.Product;
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
	
	@GetMapping("/mod")
    public String regsiterform() {
       
        return "mod";
    }
	
	/*
	 * @GetMapping("/update_product") public String updateproduct() {
	 * 
	 * return "mod"; }
	 */
	
	@RequestMapping("/update_product/{id}")
	public String updateproduct1(@PathVariable("id") int id, Model model) {
		Product p = pService.getBookById(id);
		model.addAttribute("product", p);
		return "mod";
	}
	
	@GetMapping("/kakunin")
	public String checkproduct() {
		return "kakunin";
	}
	
	@PostMapping("/register_product")
	public String registerproduct(@ModelAttribute Product b) {
		pService.save(b);

		return "redirect:/mod";

	}
}
