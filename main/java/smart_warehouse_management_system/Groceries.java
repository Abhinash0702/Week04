package smart_warehouse_management_system;

public class Groceries extends WareHouseItems{
    private String expiryDate;

    Groceries(String name,double price,String expiryDate){
        super(price,name);
        this.expiryDate=expiryDate;
    }

    public void getDetails(){
        System.out.println("Item name: "+getName());
        System.out.println("Price: "+getPrice());
        System.out.println("Expiry: "+expiryDate);
    }
}
