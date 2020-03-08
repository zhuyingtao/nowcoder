/**
 * Created by zyt on 15/10/27 10:54.
 */
public class Offer1 {
    public boolean Find(int[][] array, int target) {
        int row = array.length - 1;
        int col = 0;
        while (row >= 0 && col < array[row].length) {
            if (array[row][col] > target) {
                row--;
            } else if (array[row][col] < target)
                col++;
            else
                return true;
        }
        return false;
    }
}
