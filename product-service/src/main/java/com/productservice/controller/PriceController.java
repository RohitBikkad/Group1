package com.productservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productservice.entities.Price;
import com.productservice.service.PriceService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/price")
public class PriceController {
	
	@Autowired
	private PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }
    
    @GetMapping
    public List<Price> getAllPrices() {
        return priceService.getAllPrices();
    }

    @GetMapping("/{priceId}")
    public ResponseEntity<Price> getPriceById(@PathVariable Long priceId) {
        Price price = priceService.getPriceById(priceId);
        return ResponseEntity.of(Optional.ofNullable(price));
    }

    @PostMapping
    public ResponseEntity<Price> createPrice(@Valid @RequestBody Price price) {
        Price createdPrice = priceService.savePrice(price);
        return new ResponseEntity<>(createdPrice, HttpStatus.CREATED);
    }

    @DeleteMapping("/{priceId}")
    public ResponseEntity<Void> deletePrice(@PathVariable Long priceId) {
        priceService.deletePrice(priceId);
        return ResponseEntity.noContent().build();
    }
	
}
