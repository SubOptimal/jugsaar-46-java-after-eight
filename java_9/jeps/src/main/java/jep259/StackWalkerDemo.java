package jep259;

import static java.lang.System.out;
import static java.util.stream.Collectors.toList;

import java.lang.StackWalker.StackFrame;
import java.util.List;

public class StackWalkerDemo {

    public static void main(String[] args) {
        new StackWalkerDemo().methodOne();
    }

    private void methodOne() {
        this.methodTwo();
    }

    private void methodTwo() {
        this.methodThree();
    }

    private void methodThree() {
        List<StackFrame> stackTrace = StackWalker.getInstance()
                .walk(s -> s.collect(toList()));

        out.println("--- complete stack trace");
        printStackTrace(stackTrace);

        out.println("--- top 2 elements");
        stackTrace = StackWalker.getInstance()
                .walk(s -> s
                        .filter(frame -> frame.getClassName().startsWith("jep259"))
                        .limit(2)
                        .collect(toList()));
        printStackTrace(stackTrace);

        out.println("--- which class called me");
        new SecondClass().callMe();
    }

    private void printStackTrace(List<StackFrame> stackTrace) {
        for (StackFrame stackFrame : stackTrace) {
            out.println(stackFrame.getClassName() + " " + stackFrame.getMethodName() + " line #" + stackFrame.getLineNumber());
        }
        out.println();
    }
}
