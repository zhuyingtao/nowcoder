import java.util.Stack;

/**
 * Created by zyt on 15/10/28 14:46.
 */
public class Offer5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            // add one line
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            // add another line
        }
        return stack2.pop();
    }
}
