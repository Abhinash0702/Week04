package smart_warehouse_management_system;

public class Main {
    public static void main(String[] args) {
        // Storage for different types of warehouse items
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.add(new Electronics("Laptop", 1200, "Dell"));
        electronicsStorage.add(new Electronics("Smartphone", 800, "Samsung"));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.add(new Groceries("Apple", 3, "2025-06-12"));
        groceriesStorage.add(new Groceries("Milk", 2, "2025-02-20"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.add(new Furniture("Chair", 50, "Wood"));
        furnitureStorage.add(new Furniture("Table", 120, "Metal"));

        // Display items from different storages using the wildcard method
        System.out.println("Electronics Storage:");
        WareHouseUtils.displayAllItems(electronicsStorage.getItems());

        System.out.println("\nGroceries Storage:");
        WareHouseUtils.displayAllItems(groceriesStorage.getItems());

        System.out.println("\nFurniture Storage:");
        WareHouseUtils.displayAllItems(furnitureStorage.getItems());

    }
}
