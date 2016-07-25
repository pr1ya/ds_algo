import java.util.Arrays;

/**
 * Created by Priya on 5/23/2016.
 */
public class medainsortedarrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int l1= 0;
        int h1 = len1-1;
        int l2 = 0;
        int h2 = len2-1;
        double res = 0;

        if (len1 == 0 && len2 == 0) {
            return res;
        } else if (len2 == 0) {
            res = (len1%2== 0)? ((double)nums1[len1/2] + (double)nums1[(len1-1)/2])/2:nums1[len1/2];
            return res;
        }
        else if (len1 == 0) {
            res = (len2%2== 0)? ((double)nums2[len2/2] + (double)nums2[(len2-1)/2])/2:nums2[len2/2];
            return res;
        }

        if (len1 == 1 || len2 == 1)
            findMedian(nums1, h1, l1, nums2, h2, l2);

        while (h1-l1 > 1 && h2-l2 > 1) {

            if ((len1%2 != 0 && len2%2 != 0) || (len1%2 == 0 && len2%2 == 0)) {
                if ((h1-l1 == 1 && h2-l2 == 1)|| (h1-l1 == 2 && h2-l2 == 2))
                    findMedian(nums1, h1, l1, nums2, h2, l2);

            } else {
                if (len1%2 == 0) {
                    if (h1-l1 == 1 && h2-l2 == 2) {
                       return findMedian(nums2, h2,l2,nums1, h1, l1);
                    }
                } else {
                    if (h1-l1 == 2 && h2-l2 == 1) {
                        return findMedian(nums1, h1, l1, nums2, h2, l2);
                    }
                }

            }
            if (nums1[(h1+l1)/2] ==  nums2[(h2+l2)/2]) {
                return nums1[(h1+l1)/2];
            }else if (nums1[(h1+l1)/2] <=  nums2[(h2+l2)/2]) {
                l1 = len1%2 == 0?(h1-l1>1?(h1+l1)/2:l1):(h1-l1>2?(h1+l1)/2:l1);
                h2 = len2%2 == 0?(h2-l2>1?(h2+l2)/2:h2):(h2-l2>2?(h2+l2)/2:h2);
            }
            else if (nums1[(h1+l1)/2] >  nums2[(h2+l2)/2]) {
                h1 = len1%2 == 0? (h1-l1>1?(h1+l1)/2:h1):(h1-l1>2?(h1+l1)/2:h1);
                l2 =  len2%2 == 0?(h2-l2>1?(h2+l2)/2:l2):(h2-l2>2?(h2+l2)/2:l2);
            }

        }
        if ((len1 + len2)%2 == 0) {
          res = ((double)Math.max(nums1[l1],nums2[l2]) + (double)Math.min(nums1[h1],nums2[h2]))/2;
        } else {
            res = len1 > len2? Math.max(nums1[l1],nums2[l2]): Math.min(nums1[h1], nums2[h2]);

        }
        return res;
    }

    double findMedian(int[] odd, int oddh, int oddl, int[] even, int evenh, int evenl) {
        int size = oddh - oddl +1 + evenh-evenl + 1;
        int[] arr = new int[size];
        int m = 0;
        for (int i = oddl; i <= oddh; i++) {
           arr[m++]  = odd[i];
        }
        for (int i = evenl; i <= evenh; i++) {
            arr[m++]  = even[i];
        }
        Arrays.sort(arr);
        double ret = 0;
       if(arr.length%2==0) {
           ret = ((double)arr[arr.length/2] + (double)arr[arr.length/2 - 1])/2;
       } else {
           ret = (double)arr[arr.length/2];
       }
        return ret;
    }
}
