package com.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productservice.entities.Product;
import com.productservice.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping
	public List<Product> getAllProduct(){
		return productService.getAllProduct();
		
	}
	
	@GetMapping("/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable Long productId){
		Product product = productService.getProductById(productId);
		
		return new ResponseEntity<>(product, HttpStatus.OK);
					
	}
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product){
		Product createdProduct = productService.saveProduct(product);
		return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/{productId}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable Long productId) {

	    Product updatedProduct = productService.updateProduct(product, productId);

	    if (updatedProduct != null) {
	        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

	
	@DeleteMapping("/{productId}")
	public Product deleteProduct(@PathVariable Long productId){
		return productService.deleteProduct(productId);
		
	}

	
	
	
	
	

}
