package org.example.shopping.model;

public class CartItem {
  private Product product;
  private int quantity;

  public CartItem(Product product, int quantity) {
    this.product = product;
    this.quantity = quantity;
  }

  // getters intentionally unimplemented
}
