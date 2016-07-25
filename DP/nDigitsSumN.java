/**
 * Created by Priya on 3/2/2016.
 */
public class nDigitsSumN {
    int sum, count;

    public static void main(String[] args) {
        int n, N, k;
        n = 2;
        N = 4;
      //  N = 3;
        nDigitsSumN s = new nDigitsSumN();
        k = s.sum = s.count  = 0;
        s.generateSeries(n, k, N);
        System.out.println(s.count);
    }


    int generateSeries(int n, int k, int N) {
        if (n == k) {
            System.out.println("sum is  = " + sum);
            if (sum == N) {
                count++;
                // return 0;
            }
            sum = 0;
            return 0;
        }
        k++;
        int i;
        if (k == 1) i = 1;
        else i = 0;
        for (; i <= 9; i++) {
            System.out.println("this is fot i = " + i);

            sum = sum + i;
            generateSeries(n, k, N);
        }
        return sum;

    }
}