package org.example.shopping.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class ShoppingCart {

  private List<CartItem> items = new ArrayList<>();

  public ShoppingCart() {}

  public void addProduct(Product product, int quantity) {
    for (CartItem item: items) {
      if (item.getProduct().equals(product)) {
        // increase quantity if the product is already a cart item
        items.remove(item);
        items.add(new CartItem(product, item.getQuantity() + quantity));
        return;
      }
    }
    items.add(new CartItem(product, quantity));
  }

  public List<CartItem> getItems() {
    return Collections.unmodifiableList(items);
  }

  public double getTotal() {
    double total = 0;
    for (CartItem item: items) {
      total += item.getSubtotal();
    }
    return total;
  }
}
