import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by zyt on 15/10/27 16:23.
 */
public class Offer3 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> array = new ArrayList<>();
        while (!stack.isEmpty()) {
            array.add(stack.pop());
        }
        return array;
    }
}
