package jep271;

import java.util.ArrayList;
import java.util.List;

/**
 * The only purpose of this class is to produce some work for the GC.
 */
public class Garbage {
    private static List<Integer> list;

    public static void main(String[] args) throws InterruptedException {
        for (int j = 1; j < 3; j++) {
            list = new ArrayList<>(1_000_000);
            for (int i = 0; i < 1_000_000; i++) {
                list.add(i);
            }
            System.gc();
            list.removeIf(i -> i % 2 == 0);
            System.gc();
        }
    }
}
