package jep211;

// Java 9 no deprecation warning for the import statement
import java.io.LineNumberInputStream;

class DeprecatedImport {
    void method() {
        // Java 9 a deprecation warning is printed for this statement
        LineNumberInputStream in;
    }
}
