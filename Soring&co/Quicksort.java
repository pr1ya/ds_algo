/**
 * Created by Priya on 5/2/2016.
 */
public class Quicksort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,5,4,6,7,3,7,2,8,6};
        sort(arr, 0, 9);
        for (int i = 0; i < 10; i++) {
            System.out.println("array is : " + arr[i]);
        }
    }



    private static void sort(int[] arr, int l, int h) {
        int pivot = partition(arr,l, h);
        if (l < pivot-1)
        sort(arr,l, pivot-1);
        if (h > pivot)
        sort(arr,pivot, h);

    }

    private static int partition(int[] a, int left, int right) {
        int index = (left + right) / 2;
        //int[] temp = new int[right-left+1];
        while (left < right) {
            while (a[left] < a[index]) {
                left++;
            }
            while (a[right] > a[index]) {
                right--;
            }
            if (left <= right) {
                int t = a[left];
                a[left++] = a[right];
                a[right--] = t;
            }

        }
        return left;
    }
}
