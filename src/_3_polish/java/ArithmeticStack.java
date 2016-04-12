package _3_polish.java;

import java.util.Deque;
import java.util.LinkedList;

public class ArithmeticStack {

    private final Deque<Double> stack = new LinkedList<Double>();

    public enum Operation {
        PLUS,
        MINUS,
        TIMES,
        DIV
    }

    public void push(double x) {
        stack.push(x);
    }

    public double top() {
        return stack.peek();
    }

    private void plus() {
        stack.push(stack.pop() + stack.pop());
    }

    private void minus() {
        double x = stack.pop();
        double y = stack.pop();
        stack.push(y - x);
    }

    private void times() {
        stack.push(stack.pop() * stack.pop());
    }

    private void div() {
        double x = stack.pop();
        double y = stack.pop();
        stack.push(y / x);
    }

    public void execute(Operation op) {
        switch (op) {
            case PLUS:
                plus();
                break;
            case MINUS:
                minus();
                break;
            case TIMES:
                times();
                break;
            case DIV:
                div();
                break;
        }
    }
}