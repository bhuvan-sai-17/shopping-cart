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

    public void start() {}
}
