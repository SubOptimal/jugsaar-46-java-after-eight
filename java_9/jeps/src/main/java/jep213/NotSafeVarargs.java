package jep213;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class NotSafeVarargs{
    @SafeVarargs
    private <T> void safeDisplay(T... objects) {
        for (T object : objects) {
            out.println(object);
        }
    }

    // don't use SafeVarargs when the method body might throw an ClassCastException
    @SafeVarargs
    private void faultyMethod(List<String>... lists) {
        // probably happen somewhere else
        Object[] objectsArray = lists;
        objectsArray[0] = List.of(42);

        String value = lists[0].get(0); // lead to a ClassCastException
        safeDisplay("foo", value);
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Jane");
        names.add("John");

        NotSafeVarargs p = new NotSafeVarargs();
        p.safeDisplay(names);

        p.faultyMethod(names);
    }
}
