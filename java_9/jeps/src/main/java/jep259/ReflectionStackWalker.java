package jep259;

import static java.lang.System.out;

import java.util.stream.Stream;

public class ReflectionStackWalker {
    public static void main(String[] args) {
        new Caller().doSomeReflection();
    }

    public static class Caller {
        void doSomeReflection() {
            try {
                Callee.class.getConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace(out);
            }
        }
    }

    public static class Callee {
        public Callee() {
            out.println("--- StackWalker");
            StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE)
                    .forEach(e -> out.printf("%s %s%n", e.getClassName(), e.getMethodName()));

            out.println();
            out.println("--- StackTrace");
            Stream.of(Thread.currentThread().getStackTrace())
                    .forEach(e -> out.printf("%s %s%n", e.getClassName(), e.getMethodName()));
        }
    }
}
