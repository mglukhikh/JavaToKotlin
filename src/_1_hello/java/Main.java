package _1_hello.java;

public class Main {
    public static void main(String[] args) {
        String name = args.length > 0 ? args[0] : "Java";
        System.out.println("Hello, " + name);
    }
}
