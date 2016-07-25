import java.util.Arrays;

/**
 * Created by Priya on 3/4/2016.
 */
/*Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
  Determine the maximum value obtainable by cutting up the rod and selling the pieces.*/

public class CutRod {
    int[] memo;
    int maxCost;
  //  public static final int M
    public static void main(String[] args) {
        int[] cost = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        int n = 8;
        CutRod ct = new CutRod();
        ct.memo = new int[8];
        ct.maxCost = 0;
        Arrays.fill(ct.memo, -1);
        int ret = ct.recurse(cost, n-1);
        System.out.println("max cost is " + ret );

    }

    public int recurse(int[] cost, int n) {
        if (n < 0) return 0;
        if (memo[n] != -1) return memo[n];

        for (int j = 0; j <= n; j++) {
            maxCost = Math.max(maxCost, cost[j] + recurse(cost,n-j-1));
        }
        memo[n] = maxCost;
        return memo[n];
    }
}

