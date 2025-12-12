package com.cloud.config;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;

@Configuration
public class CloudinaryConfiguration {

	@Value("${cloudinary.cloud_name}")
	private String cloudeName;
	
	@Value("${cloudinary.api_key}")
	private String apiKey;
	
	@Value("${cloudinary.api_secret}")
	private String apiSecret;
	
	@Bean
	public Cloudinary cloudinary() {
		return new Cloudinary(Map.of("cloud_name",cloudeName,
				"api_key",apiKey,
				"api_secret",apiSecret
				));
	}
}
