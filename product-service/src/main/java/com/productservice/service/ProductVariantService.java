package com.productservice.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productservice.entities.ProductVariant;
import com.productservice.repository.ProductVariantRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductVariantService {
	
	@Autowired
	private ProductVariantRepository productVariantRepository;
	
	
	
	@Transactional
    public ProductVariant createProductVariant(ProductVariant productVariant) {
        return productVariantRepository.save(productVariant);
    }

    public List<ProductVariant> getAllProductVariants() {
        return productVariantRepository.findAll();
    }

    public Optional<ProductVariant> getProductVariantById(Long variantId) {
        return productVariantRepository.findById(variantId);
//                .orElseThrow(() -> new NotFoundException("ProductVariant not found with id: " + variantId));
    }

    
    @Transactional
    public void deleteProductVariant(Long variantId) {
        Optional<ProductVariant> existingVariant = getProductVariantById(variantId);
        existingVariant.ifPresent(productVariant -> productVariantRepository.delete(productVariant));
    }

	
}