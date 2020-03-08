import java.util.Stack;

/**
 * Created by zyt on 15/12/21 16:14.
 */
public class Offer20 {

    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;

    public void push(int node) {
        stack.push(node - min);
        if (node < min) min = node;
    }

    public void pop() {
        int i = stack.pop();
        if (i < 0) min = min - i;
    }

    public int top() {
        return stack.peek() < 0 ? min : min + stack.peek();
    }

    public int min() {
        return min;
    }
}
