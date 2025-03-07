package smart_warehouse_management_system;

public class Electronics extends WareHouseItems{
    private String brand;

    Electronics(String name, double price , String brand){
        super(price,name);
        this.brand=brand;
    }

    public void getDetails(){
        System.out.println("Item name: "+getName());
        System.out.println("Brand: "+brand);
        System.out.println("Price: "+getPrice());
    }
}
