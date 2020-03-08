/**
 * Created by zyt on 15/12/28 10:10.
 */
public class Offer23 {
    public static boolean VerifySquenceOfBST(int[] sequence) {
        return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    public static boolean VerifySquenceOfBST(int[] sequence, int start, int end) {
        if (sequence == null || sequence.length == 0) return false;
        if (end - start <= 1) return true; // leaf node
        int root = sequence[end];
        int index = 0;
        while (sequence[index] < root) {
            index++;
        }
        for (int i = index; i < end; i++) {
            if (sequence[i] < root) {
                return false;
            }
        }
        return VerifySquenceOfBST(sequence, 0, index - 1) && VerifySquenceOfBST(sequence, index, end - 1);
    }

    public static void main(String[] args) {
        VerifySquenceOfBST(new int[]{5, 7, 6, 9, 11, 10, 8});
    }
}
