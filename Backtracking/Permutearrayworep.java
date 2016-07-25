import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by priya on 5/16/16.
 */
public class Permutearrayworep {
    static List<List<Integer>> ret;
    public static void main(String[] args) {
        ret = new ArrayList<List<Integer>>();
        int[] nums = new int[]{1, 2, 2, 3 ,3, 3};
        int[] a = new int[nums.length];
        Permutearrayworep apl = new Permutearrayworep();
        apl.backtrack(a, -1, nums);

    }

    public void backtrack(int[] a,int k, int[] nums) {
        List<Integer> c = new ArrayList<Integer>();
        if (k == nums.length-1) {
            List<Integer> ar = new ArrayList<Integer>();
            for (int i = 0; i < a.length; i++) {
                System.out.print( " " + a[i]);
                ar.add(a[i]);
            }
            System.out.println();
            ret.add(c);

        } else {
            k = k + 1;
            constructCandidates(a, k, c, nums);
            for (int i = 0; i < c.size(); i++) {
                a[k] = c.get(i);
                backtrack(a, k, nums);
            }
        }

    }

    public void constructCandidates(int[] a, int k ,List<Integer> c, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            c.add(nums[i]);
        }
        for (int i = 0; i <  k; i++) {
            int ind = c.indexOf(a[i]);
            c.remove(ind);
        }
        HashSet<Integer> hs = new HashSet<Integer>();
        hs.addAll(c);
        c.clear();
        c.addAll(hs);
    }

}