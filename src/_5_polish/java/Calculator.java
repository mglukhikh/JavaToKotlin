package _5_polish.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static _5_polish.java.ArithmeticStack.*;

public class Calculator {

    static private Map<String, Operation> operationMap = new HashMap<>();
    static {
        operationMap.put("+", Operation.PLUS);
        operationMap.put("-", Operation.MINUS);
        operationMap.put("*", Operation.TIMES);
        operationMap.put("/", Operation.DIV);
    }

    static public double calc(String expr) {
        final ArithmeticStack stack = new ArithmeticStack();
        for (String arg: expr.split(" ")) {
            Operation op = operationMap.get(arg);
            if (op==null) {
                double x = Double.parseDouble(arg);
                stack.push(x);
            }
            else {
                stack.execute(op);
            }
        }
        return stack.top();
    }

    static public double calcFunctional(String expr) {
        final ArithmeticStack stack = new ArithmeticStack();
        Arrays.asList(expr.split(" ")).forEach(s -> {
            Operation op = operationMap.get(s);
            if (op==null) {
                double x = Double.parseDouble(s);
                stack.push(x);
            }
            else {
                stack.execute(op);
            }
        });
        return stack.top();
    }
}