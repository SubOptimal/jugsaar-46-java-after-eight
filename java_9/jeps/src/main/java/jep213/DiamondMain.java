package jep213;

import static java.lang.System.out;

public class DiamondMain {

    public static void main(String[] args) {
        DiamondInterface integer = new DiamondInterface<>() {
            @Override
            public Integer doSomething() {
                return 42;
            }
        };
        out.println("integer.getClass() = " + integer.doSomething().getClass());

        DiamondInterface string = new DiamondInterface<>() {
            @Override
            public String doSomething() {
                return "foobar";
            }
        };
        out.println("string.getClass() = " + string.doSomething().getClass());
    }
}
