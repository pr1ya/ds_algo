import java.util.Arrays;

/**
 * Created by Priya on 5/2/2016.
 */
public class mergesort {

    public static void main(String[] args) {
        int[] vals = new int[]{1,2};
        split(vals, 0, vals.length - 1);
        for (int i = 0; i < vals.length; i++) {
            System.out.println("result is : " + vals[i]);
        }

    }

    private static void split(int[] a, int l, int r) {
         if (l>=r) return;
        int c = (l+r)/2;
        split(a, l, c);
        split(a, c+1,r);
        merge(a, l, c, r);
    }

    private static void merge(int[]a, int left, int center, int right) {
        int[] temp = new int[right-left+1];
        int j = 0;
        int k = left; int m = center +1;
        while(k <= center && m <= right) {
            if (a[k] > a[m]) {
                temp[j++] = a[m++];
            } else {
                temp[j++] = a[k++];
            }
        }
        while (k <= center) {
            temp[j++] = a[k++];
        }
        while (m <= right) {
            temp[j++] = a[m++];
        }
        for (int i = 0; i < temp.length; i++) {
            a[left++] = temp[i];
        }
    }
}
