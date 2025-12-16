package org.example.shopping.model;

public class PriceCalculator {
  private ShoppingCart cart;
  
  public PriceCalculator(ShoppingCart cart) {
    this.cart = cart;
  }

  // intentionally unimplemented getters
  public double calculateTotal() {
    return 0;
  }
}
