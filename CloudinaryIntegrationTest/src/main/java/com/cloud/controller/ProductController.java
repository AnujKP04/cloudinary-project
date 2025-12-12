package com.cloud.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cloud.dto.ProductDto;
import com.cloud.entity.Product;
import com.cloud.service.ProductService;

@RestController
@CrossOrigin("http://localhost:5173/")
public class ProductController {
	
	@Autowired
	private ProductService prodService;
	
	@PostMapping(value= "/product", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Product> createProduct(@RequestPart("file") MultipartFile file ,
			@RequestPart("product") ProductDto product ) throws IOException{
		
		Product createdProduct = prodService.createProduct(file,product);
		return ResponseEntity.ok(createdProduct);
			
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProduct(){
		List<Product> allProduct = prodService.getAllProduct();
		return ResponseEntity.ok(allProduct);
	}
	
	@PostMapping("/upload-video")
	public ResponseEntity<String> uploadVideo(@RequestPart("file") MultipartFile file) throws IOException{
		String videoUrl = prodService.uploadVideo(file);
		return ResponseEntity.ok(videoUrl);
		
	}
	
}
