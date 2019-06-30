package jep280;

class DefaultConcat {
    public static void main(String[] args) {
        String a = "foo";
        String b = "bar";
        String c = "foobar";
        String d = "foo" + "bar";
        System.out.println(c == d);
        System.out.println(a + b);
    }
}
