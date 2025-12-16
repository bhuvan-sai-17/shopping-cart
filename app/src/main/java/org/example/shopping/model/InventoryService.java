package org.example.shopping.model;

public interface InventoryService {
    boolean isInStock(Product product, int quantity);
}
