import java.util.ArrayList;

/**
 * Created by zyt on 15/12/20 21:20.
 */
public class Offer19 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> matrixList = new ArrayList<>();
        int count = 0;
        int left = 0, right = matrix[0].length - 1;
        int up = 0, bottom = matrix.length - 1;
        while (count < matrix.length * matrix[0].length) {
            for (int i = left; i <= right; i++, count++) {
                matrixList.add(matrix[up][i]);
            }
            up++;
            if (up > bottom) break;
            for (int i = up; i <= bottom; i++, count++) {
                matrixList.add(matrix[i][right]);
            }
            right--;
            if (right < left) break;
            for (int i = right; i >= left; i--, count++) {
                matrixList.add(matrix[bottom][i]);
            }
            bottom--;
            for (int i = bottom; i >= up; i--, count++) {
                matrixList.add(matrix[i][left]);
            }
            left++;
        }
        return matrixList;
    }

    public static void main(String[] args) {
        Offer19 offer19 = new Offer19();
        //int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] matrix = new int[][]{{1}, {2}, {3}, {4}, {5}};
        System.out.println(offer19.printMatrix(matrix));
    }
}
