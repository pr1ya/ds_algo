/**
 * Created by Priya on 3/8/2016.
 */
/*
Let the dimensions of given grid be R x C.

   1) The first traversal starts from top left corner, i.e., (0, 0) and should reach left bottom corner, i.e., (R-1, 0).
      The second traversal starts from top right corner, i.e., (0, C-1) and should reach bottom right corner, i.e.,
      (R-1, C-1)/
   2) From a point (i, j), we can move to (i+1, j+1) or (i+1, j-1) or (i+1, j)

   3) A traversal gets all points of a particular cell through which it passes.
      If one traversal has already collected points of a cell, then the other traversal gets no points if goes through
      that cell again.
*/

public class DoubleMaize {
    int[][] x;
    int answer;
    public static final int INT_MIN = -150000;
    public static void main (String[] args) {
        DoubleMaize dm = new DoubleMaize();
        dm.x = new int[][]{{3, 6, 8, 2},
                {5, 2, 4, 3},
                {1, 1, 20, 10},
                {1, 1, 20, 10},
                {1, 1, 20, 10},
        };
        int points = dm.recurse(0, 0, 3);
        System.out.println("Points gathered are : " + points);
    }

    public int recurse(int i , int j , int l) {
        if (i == 4 && j == 0  && l == 3) return x[i][j] +x[i][l];
        if (i > 4 || i < 0 || j > 3 || j < 0 || l > 3 || l < 0) return INT_MIN;
        if (j == l) answer = x[i][j];
        else answer = x[i][j] + x[i][l];
        answer += max(recurse(i+1, j+1, l+1),
                recurse(i+1, j+1, l-1),
                recurse(i+1, j+1, l),
                recurse(i+1, j-1, l+1),
                recurse(i+1, j-1, l-1),
                recurse(i+1, j-1, l),
                recurse(i+1, j, l+1),
                recurse(i+1, j, l-1),
                recurse(i+1, j, l));

        return answer;
    }

    public int max (int a, int b, int c, int d, int e, int f, int g, int h, int i) {
        int p =  Math.max((Math.max(a, b)), Math.max(c, d));
        int q =  Math.max((Math.max(e,f)), Math.max(g,h));
        return Math.max(Math.max(p,q), i);
    }
}
