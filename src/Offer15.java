/**
 * Created by zyt on 15/12/17 15:52.
 */
public class Offer15 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null) return null;
        ListNode temp1 = head.next;
        head.next = null;
        while (temp1 != null) {
            ListNode temp2 = temp1.next;
            temp1.next = head;
            head = temp1;
            temp1 = temp2;
        }
        return head;
    }
}
