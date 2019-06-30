package jep259;

import static java.lang.System.out;

public class SecondClass {

    private final StackWalker walker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);

    void callMe() {
        Class<?> caller = walker.getCallerClass();
        out.println("callMe()    was called from class " + caller.getCanonicalName());
        callMeToo();
    }

    private void callMeToo() {
        Class<?> caller = walker.getCallerClass();
        out.println("callMeToo() was called from class " + caller.getCanonicalName());
    }
}
