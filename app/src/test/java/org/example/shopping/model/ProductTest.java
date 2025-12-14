package org.example.shopping.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ProductTest {
  @Test
  void testProductStoresIdNameAndPrice() {
    Product product = new Product("p1","Apple",10.0);
    assertEquals("p1", product.getId());
    assertEquals("Apple", product.getName());
    assertEquals(10.0, product.getPrice());
  }

  
}
