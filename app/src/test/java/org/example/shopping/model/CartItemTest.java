package org.example.shopping.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CartItemTest {

  @Test
  void testCartItemStoresProductAndQuantity() {
    Product product = new Product("p1", "football", 15);
    CartItem item = new CartItem(product, 2);
    assertEquals(product, item.getProduct());
    assertEquals(2, item.getQuantity());
  }

  @Test
  void cartItemCalculatesSubtotal() {
    Product product = new Product("p1", "Apple", 10.0);

    CartItem item = new CartItem(product, 3);

    assertEquals(30.0, item.getSubtotal());
  }
}
