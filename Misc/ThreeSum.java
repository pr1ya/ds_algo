import java.util.*;

/**
 * Created by Priya on 5/20/2016.
 */
public class ThreeSum {
    List<List<Integer>> res;
    public List<List<Integer>> threeSum(int[] nums) {
        res = new ArrayList<List<Integer>>();
        int[] a = new int[3];
        if(nums.length < 3) return res;
/*        ArrayList<Integer> numslist = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            numslist.add(nums[i]);
        }*/
        BackTrack(a, -1, nums);
        return res;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        res = new ArrayList<List<Integer>>();
        if(nums.length < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2 ; i++) {
            int l = i+1;
            int r = nums.length-1;
            int sum = 0 - nums[i];
            while (l < r) {
                if(nums[l] + nums[r] == sum) {
                    generateRes(nums[i], nums[l], nums[r], res);
                    while(j<k && nums[j]==nums[j-1])
                        j++;
                    while(j<k && nums[k]==nums[k+1])
                        k--
                } else if (sum > nums[l] + nums[r]) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }

    void generateRes(int a, int b, int c, List<List<Integer>> res ) {
        List<Integer> l = Arrays.asList(a,b,c);
        if(!res.contains(l)) {
            res.add(l);
        }
    }

    public void BackTrack(int[] a, int k,  int[] nums) {
        int[] c = new int[nums.length];
        int nc = 0;
        if (k == 2) {
            //add to list
            List<Integer> lst = new ArrayList<Integer>();
            for (int i = 0; i < 3; i++) {
                lst.add(a[i]);
            }
            Collections.sort(lst);
            res.add(lst);
        } else {
            k = k + 1;
            constructCandidates(a, c, k , nums);
            for (int i = 0; i < nc; i++) {
                a[k] = c[i];
                BackTrack(a,k,nums);
            }
        }
    }

    public int constructCandidates(int[] a, int[] c, int k , int[] nums) {
        boolean once = true;
        HashSet<Integer> hs = new HashSet<Integer>();
        int m = 0;

        ArrayList<Integer> numslist = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            numslist.add(nums[i]);
        }

        if(k == 0) {
            hs.addAll(numslist);
            Iterator<Integer> it = hs.iterator();
            if(it.hasNext())
                c[m++] = it.next();
            System.out.println( " k =  0 " + c[0] );
            return(nums.length);
        }

        if (k == 1) {
            if(numslist.indexOf(a[0]) != numslist.lastIndexOf(a[0])) {
                c[m++] = a[0];
            }

            while (numslist.contains(a[0])) {
                numslist.remove(numslist.indexOf(a[0]));
            }
            for (int i = 0; i < numslist.size(); i++) {
               c[m++] = numslist.get(i);
            }
            return m;
        }


       if (k == 2) {
           int rem = 0-a[0]-a[1];
           numslist.remove(a[0]);
           numslist.remove(a[1]);
           if(numslist.contains(rem)) {
               c[0] = rem;
               return 1;
           }
       }
        return m;
    }

    public int constructCandidates(int[] a, int[] c, int k , int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int m = 0;
        for (int i = 0; i < nums.length; i++) {
            if(hm.containsKey(nums[i])) {
                hm.put(nums[i], (hm.get(nums[i])) + 1);
            } else hm.put(nums[i], 1);
        }
        if (k <= 1) {
            if (k == 1 && hm.get(a[0]) == 1) {
                    hm.remove(a[0]);
            }
            Iterator<Integer> it = hm.keySet().iterator();
            while(it.hasNext()) {
                c[m++] = it.next();
            }
            return m;
        }

        if(k == 2) {
            int rem = 0-a[0]-a[1];
            for (int i = 0; i < 2; i++) {
                if(hm.get(a[i]) > 1) hm.put(a[i], hm.get(a[i] -1));
                else hm.remove(a[i]);
            }
            if (hm.containsKey(rem)) {
                c[0] = rem;
                return 1;
            } else return 0;
        }
        return 0;
    }

}

