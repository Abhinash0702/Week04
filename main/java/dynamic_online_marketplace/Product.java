package dynamic_online_marketplace;

import java.util.Objects;

public class Product<T> {
    private String name;
    private double price;
    private T category;  // Generic category

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void applyDiscount(double percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Invalid discount percentage");
        }
        double discountAmount = (price * percentage) / 100;
        price -= discountAmount;
    }

    public void displayProductDetails() {
        System.out.println("Product: " + name + ", Price: $" + price + ", Category: " + category);
    }

    @Override
    public String toString() {
        return name + " ($" + price + ", Category: " + category + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product<?> product = (Product<?>) obj;
        return Double.compare(product.price, price) == 0 &&
                Objects.equals(name, product.name) &&
                Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, category);
    }
}
