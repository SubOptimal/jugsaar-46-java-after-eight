package jep213;

import static java.lang.System.out;

public class SayableDemo {
    public static void main(String[] args) {        Sayable9 impl9 = new Implementation9();
        impl9.sayHello();
        impl9.sayGoodBye();

        Sayable8 impl8 = new Implementation8();
        impl8.abstractMethod();
        impl8.sayHello();
        impl8.sayGoodBye();

    }

    private static class Implementation8 implements Sayable8 {
        @Override
        public void abstractMethod() {
            out.printf("%s: implemented abstract method%n", this.getClass().getName());
        }
    }

    private static class Implementation9 implements Sayable9 {
        @Override
        public void abstractMethod() {
            out.printf("%s: implemented abstract method%n", this.getClass().getName());
        }

        @Override
        public void sayHello() {
            out.printf("%s: overridden interface default method sayHello says Salut%n", this.getClass().getName());
        }
    }
}
