/**
 * Created by zyt on 15/10/28 14:53.
 */
public class Offer6 {
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int l = 0, h = array.length - 1, m = 0;
        while (array[l] >= array[h]) {
            if (h - l == 1) {
                m = h;
                break;
            }
            m = (l + h) / 2;
            if (array[l] == array[h] && array[m] == array[l]) {
                return findMin(array);
            }
            if (array[m] >= array[l]) {
                l = m;
            } else if (array[m] <= array[h]) {
                h = m;
            }
        }
        return array[m];
    }

    public int findMin(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] < array[i]) {
                return array[i + 1];
            }
        }
        return array[0];
    }
}
