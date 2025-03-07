package dynamic_online_marketplace;

public class Main {
    public static void main(String[] args) {
        // Using simple String as category type
        Product<String> book1 = new Product<>("The Alchemist", 15, "Books");
        Product<String> book2 = new Product<>("1984", 20, "Books");

        Product<String> tshirt = new Product<>("Graphic T-Shirt", 30, "Clothing");
        Product<String> jeans = new Product<>("Denim Jeans", 60, "Clothing");

        Product<String> phone = new Product<>("Smartphone", 800, "Gadgets");
        Product<String> laptop = new Product<>("Laptop", 1500, "Gadgets");

        // Creating product catalogs
        ProductCatalog<String> bookCatalog = new ProductCatalog<>();
        bookCatalog.addProduct(book1);
        bookCatalog.addProduct(book2);

        ProductCatalog<String> clothingCatalog = new ProductCatalog<>();
        clothingCatalog.addProduct(tshirt);
        clothingCatalog.addProduct(jeans);

        ProductCatalog<String> gadgetCatalog = new ProductCatalog<>();
        gadgetCatalog.addProduct(phone);
        gadgetCatalog.addProduct(laptop);

        // Display products before discount
        System.out.println("Products Before Discount:");
        CatalogUtils.displayAllProducts(bookCatalog.getProducts());
        CatalogUtils.displayAllProducts(clothingCatalog.getProducts());
        CatalogUtils.displayAllProducts(gadgetCatalog.getProducts());

        // Apply Discounts
        System.out.println("\nApplying Discounts...");
        CatalogUtils.applyDiscount(book1, 10); // 10% discount on books
        CatalogUtils.applyDiscount(tshirt, 20); // 20% discount on clothing
        CatalogUtils.applyDiscount(phone, 15); // 15% discount on gadgets

        // Display products after discount
        System.out.println("\nProducts After Discount:");
        CatalogUtils.displayAllProducts(bookCatalog.getProducts());
        CatalogUtils.displayAllProducts(clothingCatalog.getProducts());
        CatalogUtils.displayAllProducts(gadgetCatalog.getProducts());
    }
}
