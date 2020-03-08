/**
 * Created by zyt on 15/12/17 16:23.
 */
public class Offer16 {

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode merged;
        if (list1.val <= list2.val) {
            merged = list1;
            merged.next = Merge(list1.next, list2);
        } else {
            merged = list2;
            merged.next = Merge(list1, list2.next);
        }
        return merged;
    }
}
