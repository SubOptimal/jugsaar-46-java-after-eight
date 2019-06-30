package jep213;

import static java.lang.System.out;

interface Sayable8 {
    // till Java 7 only abstract methods
    void abstractMethod();

    // from Java 8 default instance methods
    default void sayHello() {
        String who = this.getClass().getName();
        String what = "interface default method sayHello";
        out.printf("%s: %s%n", who, what);
    }

    default void sayGoodBye() {
        String who = this.getClass().getName();
        String what = "interface default method sayGoodBye";
        out.printf("%s: %s%n", who, what);
    }
}
