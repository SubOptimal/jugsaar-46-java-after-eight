package jep223;

import static java.lang.System.getProperty;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.List;

/**
 * Java version string scheme following semantic versioning for Java >= 9.
 * <p>
 * For Java a major.minor.security schema is used for the first three elements
 * of the Java version number:<p>
 * - Major: major release with a significant new set of features<br>
 * - Minor: backward compatible bug fixes<br>
 * - Security: critical fixes to improve security
 */
public class JavaVersion {
    public static void main(String[] args) {
        List<String> propertyNames = Arrays
                .asList("java.version", "java.vm.specification.version", "java.runtime.version", "java.vm.version");
        showFormat = "%-" + maxLength(propertyNames) + "s: %s%n";
        propertyNames.stream().forEach(JavaVersion::showProperty);
    }

    private static int maxLength(List<String> propertyNames) {
        return propertyNames.stream().mapToInt(String::length).max().orElse(1);
    }

    private static void showProperty(String name) {
        out.printf(showFormat, name, getProperty(name));
    }

    private static String showFormat;
}
