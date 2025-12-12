package com.cloud.service;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloud.dto.ProductDto;
import com.cloud.entity.Product;
import com.cloud.repository.ProductRepository;

@Service
public class ProductService {

	
	@Autowired
	private ProductRepository prodRepo;
	
	@Autowired 
	private Cloudinary cloudinary;

  
	public Product createProduct(MultipartFile file, ProductDto product) throws IOException {
		Map upload = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("folder","images"));
		System.out.println(upload);

		String imgUrl = upload.get("secure_url").toString();
		
		Product prod = new Product();
		prod.setProductName(product.getProductName());
		prod.setImgUrl(imgUrl);
		prod.setCategory(product.getCategory());
		prod.setPrice(product.getPrice());
		
		return prodRepo.save(prod);
		
	}
	
	public List<Product> getAllProduct() {
		return prodRepo.findAll();
		 
	}

	public String uploadVideo(MultipartFile file) throws IOException {
		Map upload = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("resource_type", "video","folder","videos"));
		System.out.println(upload);
		 String videoUrl = upload.get("secure_url").toString();
		return videoUrl;
	}

}
