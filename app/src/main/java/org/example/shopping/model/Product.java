package org.example.shopping.model;

public class Product {
  private final String id;
  private final String name;
  private final double price;

  public Product(String id, String name, double price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public String getId() {
    return this.id;
  }
  
  public String getName() {
    return this.name;
  }

  public Double getPrice() {
    return this.price;
  }

}

