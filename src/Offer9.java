/**
 * Created by zyt on 15/12/16 22:58.
 */
public class Offer9 {
    public int JumpFloorII(int target) {
        if (target == 1) return 1;
        else return 2 * JumpFloorII(target - 1);
    }
}
