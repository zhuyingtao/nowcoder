/**
 * Created by zyt on 15/12/16 22:33.
 */
public class Offer7 {
    public int Fibonacci(int n) {
        int a = 0, b = 1;
        if (n==0) return a;
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}
