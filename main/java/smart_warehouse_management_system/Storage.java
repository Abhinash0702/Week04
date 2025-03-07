package smart_warehouse_management_system;

import java.util.ArrayList;
import java.util.List;

public class Storage <T extends WareHouseItems>{
    private ArrayList<T> l;

    Storage(){
        l=new ArrayList<>();
    }

    public void add(T items){
        l.add(items);
    }

    public List<T> getItems(){
        return l;
    }
}
