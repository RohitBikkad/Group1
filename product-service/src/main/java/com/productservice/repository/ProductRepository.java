package com.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productservice.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
