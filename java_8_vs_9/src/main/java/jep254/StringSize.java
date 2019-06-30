package jep254;

import static java.lang.System.out;
import static org.openjdk.jol.info.GraphLayout.parseInstance;

import java.util.Arrays;

public class StringSize {

    public static void main(String[] args) {
        out.println(parseInstance(string('\u006f', 100)).toFootprint());
        out.println(parseInstance(string('\u03a9', 100)).toFootprint());
    }

    private static String string(char chr, int length) {
        out.printf("%,d x %s (%04X)%n",
                length,
                Character.getName(chr),
                (int) chr
        );
        char[] chars = new char[length];
        Arrays.fill(chars, chr);
        return new String(chars);
    }
}
