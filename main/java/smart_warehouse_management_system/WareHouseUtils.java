package smart_warehouse_management_system;

import java.util.List;

public class WareHouseUtils {

    public static void displayAllItems(List<? extends WareHouseItems> items) {
        for (WareHouseItems item : items) {
            item.getDetails();
        }
    }
}
