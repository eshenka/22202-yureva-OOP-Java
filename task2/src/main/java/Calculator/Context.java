package Calculator;

import Calculator.Commands.SingleInstruction;

import java.util.HashMap;
import java.util.Stack;

public class Context {
    private Stack<Object> stack;
    private HashMap<String, Double> parameters;

    public Context() {
        this.stack = new Stack<Object>();
        this.parameters = new HashMap<String, Double>();
    }

    public void push(Object element) {
        stack.push(element);
    }

    public double pop() {
        if (stack.peek() instanceof String) {
            return parameters.get(stack.pop());
        } else {
            return (double) stack.pop();
        }
    }

    public Object peek() {
        return stack.peek();
    }

    public void define(String key, Double value) {
        parameters.put(key, value);
    }
}
