package org.example.shopping.model;


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
}
