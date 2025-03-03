package com.example.jsonmover.service;


import com.example.jsonmover.entity.Basket;
import com.example.jsonmover.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {

    @Autowired
    private BasketRepository basketRepository;

    public Basket saveBasket(Basket basket) {
        return basketRepository.save(basket);
    }

    public List<Basket> getAllBaskets() {
        return basketRepository.findAll();
    }

    public Basket getBasketById(Long id) {
        return basketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Basket not found"));
    }

    public void deleteBasket(Long id) {
        basketRepository.deleteById(id);
    }
}