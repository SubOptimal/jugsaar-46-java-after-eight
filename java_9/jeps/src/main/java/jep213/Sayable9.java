package jep213;

import static java.lang.System.out;

interface Sayable9 {
    // till Java 7 only abstract methods
    void abstractMethod();

    // from Java 8 default instance methods
    default void sayHello() {
        say(whoAmI(), "interface default method sayHello");
    }

    default void sayGoodBye() {
        say(whoAmI(), "interface default method sayGoodBye");
    }

    // from Java 9 private instance/static methods
    private static void say(String who, String what) {
        out.printf("%s - private method say(): %s%n", who, what);
    }

    private String whoAmI() {
        return this.getClass().getName();
    }
}
