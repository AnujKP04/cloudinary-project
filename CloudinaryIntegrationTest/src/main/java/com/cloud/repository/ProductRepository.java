package com.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloud.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
