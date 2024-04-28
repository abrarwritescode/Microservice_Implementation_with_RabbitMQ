package org.example.inventoryservice.controller;

import org.example.inventoryservice.entity.Product;

import java.util.ArrayList;

public class ProductList {
    public ArrayList<Product> initializeProducts() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("2001", "burger", 100));
        products.add(new Product("2002", "cheese", 50));
        products.add(new Product("2003", "mac-chceese", 10));
        products.add(new Product("2005", "shawrma", 20));
        products.add(new Product("2006", "lassi", 30));
        return products;
    }
}