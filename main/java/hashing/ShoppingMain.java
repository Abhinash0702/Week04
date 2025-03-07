package org.example.Hashing;

import java.util.*;

class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>();
    private LinkedHashMap<String, Integer> cartItems = new LinkedHashMap<>();
    private TreeMap<Double, String> sortedItemsByPrice = new TreeMap<>();

    // Add product to the price list
    public void addProduct(String productName, double price) {
        productPrices.put(productName, price);
        System.out.println("Product " + productName + " added with price " + price);
    }

    // Add product to the cart with quantity
    public void addToCart(String productName, int quantity) {
        if (productPrices.containsKey(productName)) {
            cartItems.put(productName, quantity);
            System.out.println(quantity + " x " + productName + " added to the cart.");
        } else {
            System.out.println("Product not available.");
        }
    }

    // Remove product from cart
    public void removeFromCart(String productName) {
        if (cartItems.containsKey(productName)) {
            cartItems.remove(productName);
            System.out.println(productName + " removed from the cart.");
        } else {
            System.out.println("Product not in the cart.");
        }
    }

    // Display cart items in the order they were added
    public void displayCart() {
        System.out.println("Items in the cart (in the order added):");
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            String productName = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(productName + " - Quantity: " + quantity + " - Price: " + productPrices.get(productName));
        }
    }

    // Display items sorted by price
    public void displaySortedItemsByPrice() {
        sortedItemsByPrice.clear();
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            String productName = entry.getKey();
            double price = productPrices.get(productName);
            sortedItemsByPrice.put(price, productName);
        }

        System.out.println("Items sorted by price:");
        for (Map.Entry<Double, String> entry : sortedItemsByPrice.entrySet()) {
            System.out.println(entry.getValue() + " - Price: " + entry.getKey());
        }
    }

    // Calculate total price of items in the cart
    public void calculateTotal() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            String productName = entry.getKey();
            int quantity = entry.getValue();
            total += productPrices.get(productName) * quantity;
        }
        System.out.println("Total price: " + total);
    }
}

public class ShoppingMain {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Adding products and prices
        cart.addProduct("Laptop", 700);
        cart.addProduct("Smartphone", 500);
        cart.addProduct("Headphones", 100);
        cart.addProduct("Mouse", 25);

        // Adding products to the cart
        cart.addToCart("Laptop", 1);
        cart.addToCart("Smartphone", 2);
        cart.addToCart("Headphones", 1);

        // Display cart in order of items added
        cart.displayCart();

        // Remove an item from the cart
        cart.removeFromCart("Mouse");

        // Display cart sorted by price
        cart.displaySortedItemsByPrice();

        // Calculate total
        cart.calculateTotal();
    }
}

