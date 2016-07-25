/**
 * Created by Priya on 3/3/2016.
 */
public class LongestCommonSubsequence {
    int count;

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String str1 = "abcdfdeds";
        String str2 = "eds";
        lcs.count = 0;
        lcs.count = lcs.recurse(str1, str2, str1.length(), str2.length());
        System.out.println("number of matching characters: " + lcs.count);
    }

    int recurse(String a, String b, int x, int y) {
        if (x == 0 || y == 0) return 0;
        if (a.charAt(x-1) == b.charAt(y-1)) return 1 + recurse(a,b,x-1,y-1);
        return Math.max(recurse(a,b, x-1,y), recurse(a, b, x, y-1));
    }
}
