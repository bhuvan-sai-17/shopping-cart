package org.example.shopping.model;

public class PriceCalculator {
  private ShoppingCart cart;
  
  public PriceCalculator(ShoppingCart cart) {
    this.cart = cart;
  }

  public double calculateTotal() {
    return cart.getTotal();
  }
}
