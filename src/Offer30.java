/**
 * Created by zyt on 16/1/8 18:02.
 */
public class Offer30 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] sum = new int[array.length];
        sum[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            sum[i] = (sum[i - 1] < 0 ? array[i] : sum[i - 1] + array[i]);
        }
        int max = sum[0];
        for (int i = 0; i < sum.length; i++) {
            if (max < sum[i]) {
                max = sum[i];
            }
        }
        return max;
    }
}
