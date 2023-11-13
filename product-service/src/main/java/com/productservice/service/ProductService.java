package com.productservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productservice.entities.Product;
import com.productservice.repository.ProductRepository;

@Service
public class ProductService {
	
	
	@Autowired
	private ProductRepository productRepository;

	public ProductService() {
		super();
	}
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	
	public Product getProductById(Long id) {
		Optional<Product> optional = productRepository.findById(id);
		
		return optional.isPresent() ? optional.get() : null;
	}
	
	public List<Product> getAllProduct(){
		return productRepository.findAll();
	}

	public Product updateProduct(Product product, Long productId) {
		// TODO Auto-generated method stub
		Product existingProduct = getProductById(productId);

	    if (existingProduct != null) {
	        existingProduct.setProduct_key(product.getProduct_key());
	        existingProduct.setProductDescription(product.getProductDescription());
	        existingProduct.setProductName(product.getProductName());

	        return saveProduct(existingProduct);
	    }
		return null;
	}
	
	public Product deleteProduct(Long productId) {
		Product product = getProductById(productId);
		
		if(product!=null) {
			productRepository.delete(product);
			return product;
		}
		return null;
		
		
	}
//	public Employee deleteEmployee(Long id) {
//		Employee employee = getEmployee(id);
//		if(employee!=null) {
//			empRepo.delete(employee);
//			return employee;
//		}
//		return null;
//	}
	

}
