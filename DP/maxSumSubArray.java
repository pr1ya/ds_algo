import java.util.List;

/**
 * Created by Priya on 5/26/2016.
 */
public class maxSumSubArray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int maxSum = nums[0];
        int currmax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currmax = Math.max(nums[i], currmax+nums[i]);
            maxSum = Math.max(maxSum,currmax);
        }
        return maxSum;
    }

    public int maxSubArray(final List<Integer> a) {
        if (a.size() == 0) return 0;
        if(a.size() == 1) return a.get(0);

        int maxSum =  a.get(0);
        int currmax =  a.get(0);
        for (int i = 1; i < a.size(); i++) {
            currmax = Math.max( a.get(i), currmax+ a.get(i));
            maxSum = Math.max(maxSum,currmax);
        }
        return maxSum;
    }
}
