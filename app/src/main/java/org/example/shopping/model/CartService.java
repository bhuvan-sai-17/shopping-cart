package org.example.shopping.model;

import java.util.List;

public class CartService {

  private final ShoppingCart cart;
  private final InventoryService inventory;

  public CartService(ShoppingCart cart, InventoryService inventory) {
    this.cart = cart;
    this.inventory = inventory;
  }

  public void addProduct(Product product, int quantity) {
    if (inventory.isInStock(product, quantity)) {
      cart.addProduct(product, quantity);
    }
  }

  public List<CartItem> getItems() {
    return cart.getItems();
  }
}
