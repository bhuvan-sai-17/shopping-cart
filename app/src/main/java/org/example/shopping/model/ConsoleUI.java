package org.example.shopping.model;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleUI {
  private final CartService cartService;
  private final PrintStream out;
  private final Scanner scanner;

  public ConsoleUI(CartService cartService, PrintStream out, InputStream in) {
    this.cartService = cartService;
    this.out = out;
    this.scanner = new Scanner(in);
  }

  public void start() {
    while (true) {
      out.println("Enter either add or exit");
      String command = scanner.nextLine();

      if (command.equalsIgnoreCase("exit")) {
        out.println("Bye!");
        break;
      }

      if (command.equalsIgnoreCase("add")) {
        String id = scanner.nextLine();
        String name = scanner.nextLine();
        double price = Double.parseDouble(scanner.nextLine());
        int quantity = Integer.parseInt(scanner.nextLine());

        Product product = new Product(id, name, price);
        cartService.addProduct(product, quantity);

        out.println("Cart:");
        for (CartItem item : cartService.getItems()) {
          out.println("- "
              + item.getProduct().getName()
              + " x" + item.getQuantity()
              + " (" + item.getProduct().getPrice() + ")");
        }
      }

      out.println("------");
    }
  }

}
