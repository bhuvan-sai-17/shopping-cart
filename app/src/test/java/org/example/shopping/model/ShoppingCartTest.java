package org.example.shopping.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

  @Test
  void testNewCartIsEmpty() {
    ShoppingCart cart = new ShoppingCart();

    assertTrue(cart.getItems().isEmpty());
  }

  @Test
  void testAddingProductCreatesCartItem() {
    ShoppingCart cart = new ShoppingCart();
    Product product = new Product("p1", "Apple", 10.0);

    cart.addProduct(product, 2);

    assertEquals(1, cart.getItems().size());
    assertEquals(20.0, cart.getTotal());
  }

  @Test
  void testAddingSameProductTwiceIncreasesQuantity() {
    ShoppingCart cart = new ShoppingCart();
    Product product = new Product("p1", "Apple", 10.0);

    cart.addProduct(product, 1);
    cart.addProduct(product, 2);

    assertEquals(1, cart.getItems().size());
    assertEquals(30.0, cart.getTotal());
  }
}
