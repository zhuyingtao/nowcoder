import java.util.Stack;

/**
 * Created by zyt on 15/12/25 17:16.
 */
public class Offer21 {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA.length == 0 || popA.length == 0) return false;
        Stack<Integer> stack = new Stack<>();
        int aIndex = 0;
        for (int i = 0; i < popA.length; i++) {
            int dst = popA[i];
            while (stack.isEmpty() || stack.peek() != dst) {
                if (aIndex >= pushA.length) return false;
                stack.push(pushA[aIndex++]);
            }
            stack.pop();
        }
        return stack.isEmpty();
    }
}
