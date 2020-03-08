/**
 * Created by zyt on 15/12/16 22:51.
 */
public class Offer8 {
    public int JumpFloor(int target) {
        if (target == 1) return 1;
        if (target == 2) return 2;
        int n1 = 1, n2 = 2;
        for (int i = 3; i <= target; i++) {
            int temp = n2 + n1;
            n1 = n2;
            n2 = temp;
        }
        return n2;
    }
}
