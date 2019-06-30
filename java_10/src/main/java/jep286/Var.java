package jep286;

import java.util.HashMap;
import java.util.Map;

public class Var {
    class CustomerID {

    }

    class OrderID {

    }

    public static void main(String[] args) {
        var map = new HashMap<CustomerID, Map<OrderID, String>>();

        for (var entry : map.entrySet()) {
            // ...
            CustomerID key = entry.getKey();
            Map<OrderID, String> value = entry.getValue();
        }
    }
}
