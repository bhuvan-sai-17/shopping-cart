package org.example.shopping.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CartServiceTest {

  @Test
  void testAddsProductToCartWhenInventoryHasStock() {
    InventoryService inventory = mock(InventoryService.class);
    ShoppingCart cart = new ShoppingCart();
    CartService cartService = new CartService(cart, inventory);

    Product apple = new Product("p1", "Apple", 10.0);

    when(inventory.isInStock(apple, 2)).thenReturn(true);

    cartService.addProduct(apple, 2);

    assertEquals(1, cart.getItems().size());
    verify(inventory).isInStock(apple, 2);
  }

  @Test
  void cartServiceDelegatesAddToShoppingCart() {
    
    ShoppingCart cart = mock(ShoppingCart.class);
    InventoryService inventory = mock(InventoryService.class);

    CartService service = new CartService(cart,inventory);

    Product product = new Product("p1", "Apple", 10.0);

    when(inventory.isInStock(product, 2)).thenReturn(true);
    service.addProduct(product, 2);

    verify(inventory).isInStock(product, 2);
    verify(cart).add(product, 2);
  }
}
