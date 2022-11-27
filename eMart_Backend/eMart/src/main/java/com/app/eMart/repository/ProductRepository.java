package com.app.eMart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.eMart.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
