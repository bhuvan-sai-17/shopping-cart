package org.example;

import org.example.shopping.model.CartService;
import org.example.shopping.model.InventoryService;
import org.example.shopping.model.ShoppingCart;
import org.example.shopping.model.ConsoleUI;

public class App {

  public static void main(String[] args) {
    InventoryService inventory = (product, quantity) -> true; // simple stub
    ShoppingCart cart = new ShoppingCart();
    CartService cartService = new CartService(cart, inventory);

    ConsoleUI ui = new ConsoleUI(cartService, System.out, System.in);
    ui.start();
  }
}
