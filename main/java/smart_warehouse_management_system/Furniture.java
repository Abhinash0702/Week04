package smart_warehouse_management_system;

public class Furniture extends WareHouseItems {
    private String woodUsed;

    Furniture(String name, double price ,String woodUsed){
        super(price,name);
        this.woodUsed=woodUsed;
    }

    public void getDetails(){
        System.out.println("Item name: "+getName());
        System.out.println("Wood Used: "+woodUsed);
        System.out.println("Price: "+getPrice());
    }
}
