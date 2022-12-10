package com.app.eMart.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.eMart.entity.Category;
import com.app.eMart.entity.Product;
import com.app.eMart.repository.CategoryRepository;
import com.app.eMart.repository.ProductRepository;
import com.app.eMart.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public List<Product> getAllProducts() {
	
		return productRepository.findAll();
	}

	@Override
	public Product createProduct(Product product) {
		
		return productRepository.save(product);
	}


	@Override
	public Optional<Product> getProductById(long id) {
		
		return productRepository.findById(id) ;
	}

	@Override
	public Object updateProduct(Long id, Product product) {
		
		 Optional<Product> theProduct = productRepository.findById(id);
		 
		 if (theProduct.isPresent()) {
			 
		 Product _product = theProduct.get();
		 
		 _product.setProductBrand(product.getProductBrand());
		 _product.setProductDate(product.getProductDate());
		 _product.setProductDescription(product.getProductDescription());
		 _product.setProductImageUrl(product.getProductImageUrl());
		 _product.setProductName(product.getProductName());
		 _product.setProductPrice(product.getProductPrice());
		 _product.setCatId(product.getCatId());
		 
		return productRepository.save(_product);
		 }
		 else
			 return "Product" + id + " not found";
	}

	@Override
	public void deleteProductById(long id) {
		
		productRepository.deleteById(id);;
	}

	@Override
	public List<Category> getAllCategory() {
		
		return categoryRepository.findAll();
	}
	
	
	
}
