import java.util.HashMap;

/**
 * Created by zyt on 15/12/31 10:15.
 */
public class Offer25 {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode newHead = new RandomListNode(pHead.label);
        HashMap<RandomListNode, RandomListNode> hashMap = new HashMap<>();
        RandomListNode temp = pHead;
        RandomListNode newTemp = newHead;
        while (temp != null) {
            hashMap.put(temp, newTemp);
            temp = temp.next;
            if (temp != null) {
                RandomListNode newNode = new RandomListNode(temp.label);
                newTemp.next = newNode;
                newTemp = newTemp.next;
            }
        }
        temp = pHead;
        newTemp = newHead;
        while (temp != null) {
            newTemp.random = hashMap.get(temp.random);
            temp = temp.next;
            newTemp = newTemp.next;
        }
        return newHead;
    }
}
