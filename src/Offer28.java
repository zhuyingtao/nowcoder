/**
 * Created by zyt on 16/1/8 13:59.
 */
public class Offer28 {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) return 0;
        int val = array[0], count = 1;
        for (int i = 1; i < array.length; i++) {
            if (count == 0) {
                val = array[i];
                count = 1;
            }
            if (val != array[i]) {
                count--;
            } else {
                count++;
            }
        }
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == val) {
                count++;
            }
        }
        return count > array.length / 2 ? val : 0;
    }
}
