package com.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productservice.entities.ProductVariant;
import com.productservice.service.ProductVariantService;

@RestController
@RequestMapping("/product-variants")
public class ProductVariantController {
	
	@Autowired
	private ProductVariantService productVariantService;
	
	@PostMapping
	public ResponseEntity<ProductVariant> createProductVariant(@RequestBody ProductVariant productVariant) {
        ProductVariant createdVariant = productVariantService.createProductVariant(productVariant);
        return new ResponseEntity<>(createdVariant, HttpStatus.CREATED);
    }
	
	@GetMapping
	public ResponseEntity<List<ProductVariant>> getAllProductVariants() {
        List<ProductVariant> variants = productVariantService.getAllProductVariants();
        return new ResponseEntity<>(variants, HttpStatus.OK);
    }
	
	

}
