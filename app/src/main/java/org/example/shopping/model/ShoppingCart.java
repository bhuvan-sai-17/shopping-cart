package org.example.shopping.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

  private List<CartItem> items = new ArrayList<>();

  public ShoppingCart() {}

  public void addProduct(Product product, int quantity) {
    CartItem existing = findItem(product);
    if (existing != null) {
      items.remove(existing);
      items.add(new CartItem(product, existing.getQuantity() + quantity));
    } else {
      items.add(new CartItem(product, quantity));
    }

  }

  private CartItem findItem(Product product) {
    for (CartItem item: items) {
      if (item.getProduct().equals(product)) {
        return item;
      }
    }
    return null;
  }

  public List<CartItem> getItems() {
    return new ArrayList<>(items);
  }

  public double getTotal() {
    double total = 0;
    for (CartItem item: items) {
      total += item.getSubtotal();
    }
    return total;
  }
}
