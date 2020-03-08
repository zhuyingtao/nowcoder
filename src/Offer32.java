import java.util.Arrays;

/**
 * Created by zyt on 16/1/13 15:31.
 */
public class Offer32 {

    // one more day....
    public int compare(String n, String m) {
        String nm = n + m;
        String mn = m + n;
        return nm.compareTo(mn);
    }

    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        Arrays.sort(numbers);
        String str = numbers[0] + "";
        for (int i = 1; i < numbers.length; i++) {
            if (this.compare(str, numbers[i] + "") < 0) {
                str = str + numbers[i];
            } else {
                str = numbers[i] + str;
            }
        }
        return str;
    }

    public static void main(String[] args) {
        double a=(10+5)/2;
        System.out.println(a);
    }
}
