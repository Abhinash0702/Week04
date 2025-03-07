package dynamic_online_marketplace;

import java.util.List;

public class CatalogUtils {
    public static void applyDiscount(Product<?> product, double percentage) {
        product.applyDiscount(percentage);
    }

    public static void displayAllProducts(List<? extends Product<?>> products) {
        for (Product<?> product : products) {
            product.displayProductDetails();
        }
    }
}
