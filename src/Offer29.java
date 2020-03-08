import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by zyt on 16/1/8 14:53.
 */
public class Offer29 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> array = new ArrayList<>();
        if (k > input.length) return array;
        TreeSet<Integer> tree = new TreeSet<>();
        for (int i = 0; i < input.length; i++) {
            tree.add(input[i]);
        }
        for (int i = 0; i < k; i++) {
            array.add(tree.pollFirst());
        }
        return array;
    }
}
