import java.util.ArrayList;

/**
 * Created by zyt on 15/12/17 13:28.
 */
public class Offer13 {
    public void reOrderArray(int[] array) {
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0)
                even.add(array[i]);
            else
                odd.add(array[i]);
        }
        int i = 0;
        while (i < array.length) {
            if (i < odd.size()) {
                array[i] = odd.get(i);
            } else {
                array[i] = even.get(i - odd.size());
            }
            i++;
        }
    }
}
