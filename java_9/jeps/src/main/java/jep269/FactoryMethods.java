package jep269;

import static java.lang.System.out;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class FactoryMethods {
    public static void main(String[] args) {
        // List.of(e1)
        // List.of(e1, e2)
        // ...
        // List.of(e1, ..., e10)
        // List.of(e1...)
        List<String> list = List.of("value1", "value2", "value3");
        out.println(list);
        out.println(list.getClass());

        // Set.of(e1)
        // Set.of(e1, e2)
        // ...
        // Set.of(e1, ..., e10)
        // Set.of(e1...)
        Set<String> set = Set.of("value1", "value2", "value3");
        out.println(set);
        out.println(set.getClass());

        // Map.of(k1, v1)
        // Map.of(k1, v1, k2, k2)
        // ...
        // Map.of(k1, v1, ..., k10, v10)
        Map<String, String> map = Map.of(
                "key1", "value1",
                "key2", "value2",
                "key3", "value3"
        );
        out.println(map);
        out.println(map.getClass());

        // Map.ofEntries(e1...)
        Map<String, String> ofEntries = Map.ofEntries(
                        Map.entry("key4", "value4"),
                        Map.entry("key5", "value5"),
                        Map.entry("key6", "value6")
                );
        out.println(ofEntries);
        out.println(ofEntries.getClass());
    }
}
