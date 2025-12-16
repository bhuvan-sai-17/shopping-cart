package org.example.shopping.model;

import org.example.shopping.model.Product;
import org.example.shopping.model.ShoppingCart;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CartServiceTest {

  @Test
  void addsProductToCartWhenInventoryHasStock() {
    // Arrange
    InventoryService inventory = mock(InventoryService.class);
    ShoppingCart cart = new ShoppingCart();
    CartService cartService = new CartService(cart, inventory);

    Product apple = new Product("p1", "Apple", 10.0);

    when(inventory.isInStock(apple, 2)).thenReturn(true);

    // Act
    cartService.addProduct(apple, 2);

    // Assert
    assertEquals(1, cart.getItems().size());
    verify(inventory).isInStock(apple, 2);
  }
}
