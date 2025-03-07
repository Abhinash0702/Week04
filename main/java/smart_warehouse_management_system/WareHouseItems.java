package smart_warehouse_management_system;

abstract public class WareHouseItems {
    private double price;
    private String name;

    WareHouseItems(double price, String name){
        this.price=price;
        this.name=name;

    }

    public String getName(){
        return name;
    }
    public  double getPrice(){
        return price;
    }

    public abstract void getDetails();
}

