package org.example.shopping.model;

// import org.example.shopping.model.Product;
// import org.example.shopping.model.ShoppingCart;
// import org.example.shopping.model.CartService;
// import org.example.shopping.model.InventoryService;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

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
        in);

    ui.start();

    assertTrue(cart.getItems().size() == 1);
  }

  @Test
  void testShowCartContentsPrintsAllItems() {
    CartService service = mock(CartService.class);
    PrintStream out = mock(PrintStream.class);

    Product apple = new Product("p1", "Apple", 10.0);
    Product banana = new Product("p2", "Banana", 5.0);

    when(service.getItems()).thenReturn(Arrays.asList(
        new CartItem(apple, 2),
        new CartItem(banana, 3)));

    ConsoleUI ui = new ConsoleUI(service, out, System.in);
    ui.showCartContents();

    verify(out).println("- Apple x2 ($10.0 each)");
    verify(out).println("- Banana x3 ($5.0 each)");
  }
}
