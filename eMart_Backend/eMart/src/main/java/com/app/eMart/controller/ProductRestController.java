package com.app.eMart.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.eMart.entity.Product;
import com.app.eMart.service.ProductService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
@RestController
public class ProductRestController {

	private ProductService productService;

	@Autowired
	public ProductRestController(ProductService theProductService){
		this.productService=theProductService;
	}

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/allProducts")
	public ResponseEntity<Object>getAllProducts(){

		try {
			return new ResponseEntity<>( productService.getAllProducts(), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("contoller method getAllProducts thrown exception {} at user {} "+ e.toString());
			return new ResponseEntity<>("Error Occured at contoller getAllProducts() ", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/getProductById/{id}")
	public ResponseEntity<Object> getProductById(@PathVariable("id") long id){

		try {
			return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
		} catch (Exception e) {

			e.printStackTrace();
			logger.error("contoller method getProductById thrown exception {} at user {} "+ e.toString());
			return new ResponseEntity<>("Error Occured at contoller getProductById() ", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


	@PostMapping("/createProduct")
	public ResponseEntity<Object> createProduct(@RequestBody Product product) {

		try {
			return new ResponseEntity<>( productService.createProduct(product), HttpStatus.OK);
		} catch (Exception e) {

			e.printStackTrace();
			logger.error("contoller method createProduct thrown exception {} at user {} "+ e.toString());
			return new ResponseEntity<>("Error Occured at contoller createProduct() ", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/updateProduct/{id}")
	public  ResponseEntity<Object> updateProduct(@PathVariable("id") long id,@RequestBody Product product ) {


		try {
			return new ResponseEntity<>( productService.updateProduct(id,product), HttpStatus.OK);
		} catch (Exception e) {

			e.printStackTrace();
			logger.error("conrtoller method updateProduct thrown exception {} at user {} "+ e.toString());
			return new ResponseEntity<>("Error Occured at controller updateProduct() ", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/deleteProductById/{id}")
	public ResponseEntity<Object> deleteProductById(@PathVariable("id") long id){

		try {
			productService.deleteProductById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {

			e.printStackTrace();
			logger.error("conrtoller method deleteProductById thrown exception {} at user {} "+ e.toString());
			return new ResponseEntity<>("Error Occured at controller deleteProductById() ", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}



}
