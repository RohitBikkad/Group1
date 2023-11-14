package com.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productservice.entities.Price;
import com.productservice.repository.PriceRepository;

@Service
public class PriceService {
	
	private final PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }
	
    public List<Price> getAllPrices() {
        return priceRepository.findAll();
    }

    public Price getPriceById(Long priceId) {
        return priceRepository.findById(priceId).orElse(null);
    }

    public Price savePrice(Price price) {
        return priceRepository.save(price);
    }

    public void deletePrice(Long priceId) {
        priceRepository.deleteById(priceId);
    }

}
