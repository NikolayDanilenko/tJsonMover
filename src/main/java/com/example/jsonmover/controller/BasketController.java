package com.example.jsonmover.controller;

import com.example.jsonmover.entity.Basket;
import com.example.jsonmover.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/baskets")
public class BasketController {

    @Autowired
    private BasketService basketService;

    @PostMapping
    public ResponseEntity<Basket> createBasket(@RequestBody Basket basket) {
        Basket savedBasket = basketService.saveBasket(basket);
        return ResponseEntity.ok(savedBasket);
    }

    @GetMapping
    public ResponseEntity<List<Basket>> getAllBaskets() {
        List<Basket> baskets = basketService.getAllBaskets();
        return ResponseEntity.ok(baskets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Basket> getBasketById(@PathVariable Long id) {
        Basket basket = basketService.getBasketById(id);
        return ResponseEntity.ok(basket);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBasket(@PathVariable Long id) {
        basketService.deleteBasket(id);
        return ResponseEntity.noContent().build();
    }
}