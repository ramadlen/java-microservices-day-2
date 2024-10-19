package com.java.microservice.inventory_service.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.microservice.inventory_service.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class InventoryService {
     private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode, Integer quantity) {
        return inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);
    }
}
