package Calculator;

import Calculator.Commands.SingleInstruction;
import Exceptions.ContextException;
import Exceptions.UndefinedParameterException;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Stack;

public class Context {
    private final Stack<String> stack;
    private final HashMap<String, Double> parameters;

    public Context() {
        this.stack = new Stack<String>();
        this.parameters = new HashMap<String, Double>();
    }

    public void push(String element) {
        stack.push(element);
    }

    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public double pop() throws ContextException {
        try {
            if (!isNumeric(stack.peek())) {
                Double parameter = parameters.get(stack.peek());

                if (parameter == null) {
                    throw new UndefinedParameterException("Parameter was not defined");
                }

                return parameters.get(stack.pop());
            } else {
                return Double.parseDouble(stack.pop());
            }
        } catch (EmptyStackException exception) {
            throw new ContextException("Too few elements in stack to perform operation");
        }
    }

    public String peek() throws ContextException {
        try {
            return stack.peek();
        } catch (EmptyStackException exception) {
            throw new ContextException("Too few elements in stack to perform operation");
        }
    }

    public void define(String key, Double value) {
        parameters.put(key, value);
    }
}
