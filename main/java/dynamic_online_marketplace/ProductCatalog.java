package dynamic_online_marketplace;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalog<T> {
    private List<Product<T>> products;

    public ProductCatalog() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product<T> product) {
        products.add(product);
    }

    public List<Product<T>> getProducts() {
        return products;
    }

    public void displayCatalog() {
        for (Product<T> product : products) {
            product.displayProductDetails();
        }
    }
}
