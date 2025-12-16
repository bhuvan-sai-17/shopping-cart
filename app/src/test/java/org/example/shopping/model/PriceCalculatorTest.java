package org.example.shopping.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PriceCalculatorTest {
  @Test
  void testCalculateTotalPriceFromShoppingCart() {
    ShoppingCart cart = new ShoppingCart();
    cart.addProduct(new Product("p1", "apple", 10), 2);
    cart.addProduct(new Product("p2", "orange", 2), 1);

    PriceCalculator pc = new PriceCalculator(cart);

    assertEquals(25, pc.calculateTotal());
  }
  
}
