import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Priya on 5/12/2016.
 */
public class kthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>());
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i];)
        }

    }
}
