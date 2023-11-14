package com.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productservice.entities.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long>{

}
