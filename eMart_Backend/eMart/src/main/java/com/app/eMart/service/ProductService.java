package com.app.eMart.service;

import java.util.List;
import java.util.Optional;

import com.app.eMart.entity.Product;

public interface ProductService {

	public List<Product> getAllProducts();

	public Product createProduct(Product product);

	public Optional<Product> getProductById(long id);

	public Object updateProduct(Long id, Product product);

	public void deleteProductById(long id);

}
