/**
 * Created by zyt on 15/12/17 13:45.
 */
public class Offer14 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        if (k > count) {
            return null;
        }
        int number = 0;
        while (number++ < count - k) {
            head = head.next;
        }
        return head;
    }
}
