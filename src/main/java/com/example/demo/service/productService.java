package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.bookStore.entity.Book;
import com.example.demo.entity.Product;
import com.example.demo.repository.productRepository;

@Service
public class productService {

	@Autowired 
	private productRepository productRepo;
	
	 public ArrayList<Product> getAllProduct(){
	        return (ArrayList<Product>) productRepo.findAll();
	 }
	 
	 public void save(Product p) {
			productRepo.save(p);
	 }
	 
	 public Product getBookById(int id) {
			return productRepo.findById(id).get();
	}
		
		
}
