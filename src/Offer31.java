/**
 * Created by zyt on 16/1/13 11:23.
 */
public class Offer31 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int num = i;
            while (num != 0) {
                if (num % 10 == 1)
                    count++;
                num /= 10;
            }
        }
        return count;
    }
}
