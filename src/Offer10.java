/**
 * Created by zyt on 15/12/17 11:39.
 */
public class Offer10 {
    public int RectCover(int target) {
        if (target == 0) return 1;
        if (target == 1) return 1;
        int n0 = 1, n1 = 1;
        for (int i = 2; i <= target; i++) {
            int temp = n0 + n1;
            n0 = n1;
            n1 = temp;
        }
        return n1;
    }
}
