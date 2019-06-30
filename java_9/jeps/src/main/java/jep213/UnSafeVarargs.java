package jep213;

public class UnSafeVarargs {
    // use SafeVarargs when the processing inside the method body cannot lead to ClassCastException
    @SafeVarargs
    private <T> T[] varargsToArray(T... args) {
		System.out.println("varargsToArray: " + args.getClass());
        return args;
    }

    private <T> T[] paramsToArray(T a, T b) {
        // this will always be a call to varargsToArray(Object, Object)
        return varargsToArray(a, b);
    }

    public static void main(String[] args) {
        UnSafeVarargs o = new UnSafeVarargs();
        System.out.println("### varargsToArray(\"Cafebabe\", \"Duke\")");
        String[] names = o.varargsToArray("Cafebabe", "Duke");
        System.out.println("names = " + names);

		System.out.println();
        System.out.println("### varargsToArray(1, 2)");
        Integer[] ints = o.varargsToArray(1, 2);
        System.out.println("ints = " + ints);

		System.out.println();
        System.out.println("paramsToArray(\"Cafebabe\", \"Duke\")");
        String[] namesToo = o.paramsToArray("Cafebabe", "Duke");
        System.out.println("namesToo = " + namesToo);
    }
}
