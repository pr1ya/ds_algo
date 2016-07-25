import java.util.Arrays;

/**
 * Created by Priya on 3/4/2016.
 */

/*
Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm}
valued coins, how many ways can we make the change? The order of coins doesn’t matter.
*/
public class CoinChange {
    int[] memo;
    int count;
    int i;
    public static void main(String[] args ) {
        int n = 4;
        int[] coins = new int[] {1, 2, 3};
        CoinChange cn = new CoinChange();
        cn.memo = new int[n];
        cn.count = 0;
        cn.i = coins.length -1;
        Arrays.fill(cn.memo, -1);
        int res = cn.recurse(coins, n, 0);
        System.out.println("number of ways is: " + cn.count);
    }

    int recurse(int[] coins, int n, int tempLength) {
        if (n == 0) {

           return 1;
        }
          count = 0;

        for (int j = tempLength; j < coins.length; j++) {
           if (n-coins[j] >= 0) {
               count += recurse(coins, n - coins[j], j);
           }
        }
        return count;
    }
}
