package _3_polish.java;

import java.util.Deque;
import java.util.LinkedList;
import java.util.function.BiFunction;

public class ArithmeticStack {

    private final Deque<Double> stack = new LinkedList<Double>();

    public enum Operation {
        PLUS((x, y) -> x + y),
        MINUS((x, y) -> y - x),
        TIMES((x, y) -> x * y),
        DIV((x, y) -> y / x);

        final BiFunction<Double, Double, Double> function;

        Operation(BiFunction<Double, Double, Double> function) {
            this.function = function;
        }
    }

    public void push(double x) {
        stack.push(x);
    }

    public double top() {
        return stack.peek();
    }

    public void execute(Operation op) {
        stack.push(op.function.apply(stack.pop(), stack.pop()));
    }
}