package org.example.shopping.model;

// import org.example.shopping.model.Product;
// import org.example.shopping.model.ShoppingCart;
// import org.example.shopping.model.CartService;
// import org.example.shopping.model.InventoryService;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class ConsoleUITest {

  @Test
  void userCanAddProductViaConsole() {
    InventoryService inventory = mock(InventoryService.class);
    ShoppingCart cart = new ShoppingCart();
    CartService cartService = new CartService(cart, inventory);

    // Product apple = new Product("p1", "Apple", 10.0);
    when(inventory.isInStock(any(), anyInt())).thenReturn(true);

    String input = "add\np1\nApple\n10\n2\nexit\n";
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    ConsoleUI ui = new ConsoleUI(
        cartService,
        new PrintStream(out),
        in
      );

    ui.start();

    assertTrue(cart.getItems().size() == 1);
  }
}
