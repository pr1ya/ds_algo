import java.util.ArrayList;
import java.util.List;

/**
 * Created by Priya on 5/17/2016.
 */
public class GenerateParentheses {
    List<String> ret;
    public List<String> generateParenthesis(int n) {
        ret = new ArrayList<String>();
        if (n == 0) return ret;
        boolean[] a = new boolean[2*n];
        BackTrack(a, -1, n) ;
        return ret;

    }

    public void BackTrack(boolean[] a, int k, int n) {
        boolean[] c = new boolean[2];
        Integer nc = 0;
        if (k == 2*n-1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 2*n; i++) {
                if (a[i]) {
                    sb.append('(');
                } else {
                    sb.append(')');
                }
            }
            ret.add(sb.toString());
            System.out.println(sb.toString());
        } else {
            k = k+1;
            constructCandidates(a,c,k,n,nc);
            for (int i = 0; i < nc; i++) {
                a[k] = c[i];
                BackTrack(a,k,n);
            }
        }
    }

    public void constructCandidates(boolean[] a,boolean[] c, int k, int n, Integer nc) {
        int open = 0;
        int close = 0;
        for (int i = 0; i < k; i++) {
            if (a[i]) open++;
            else close++;
        }
        if (open > close && open < n) {
            c[0] = true;
            c[1] = false;
            nc = 2;
        } else if(open == n) {
            c[0] = false;
            nc = 1;
        } else if (open == close) {
            c[0] = true;
            nc = 1;
        }
    }


}
