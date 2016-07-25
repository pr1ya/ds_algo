import java.util.*;

/**
 * Created by Priya on 5/12/2016.
 */
public class koccuranceelement {
    public ArrayList<Integer> topKFrequent(int[] nums, int k) {
        ArrayList<Integer>  ret = new ArrayList<Integer>();
        HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hs.containsKey(nums[i])) {
                int val = hs.get(nums[i]);
                val++;
                hs.put(nums[i],val);
              //increment value
            } else {
                hs.put(nums[i], 1);
            }

        }
       //
        Set<Map.Entry<Integer,Integer>> etset= hs.entrySet();

        List<Map.Entry<Integer,Integer>> values = new ArrayList<Map.Entry<Integer,Integer>>(etset);
        Collections.sort(values, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        int x = values.size() - k;
        for (int i = x; i < values.size(); i++) {
            ret.add(values.get(i).getKey());
        }

        return ret;
    }
}
