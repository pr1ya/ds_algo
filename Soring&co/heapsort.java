import java.util.PriorityQueue;

/**
 * Created by Priya on 5/2/2016.
 */
public class heapsort {

    private  class MyPriorityQueue {
        int[] q; //array
        int n; //size of queue
        public static final int MAX = 10;

        public MyPriorityQueue() {
            q = new int[MAX +1];
            n = 0;
        }
        int getParent(int c) {
            if (c == 1) return -1;
            return c/2;
        }

        int getLowerChild(int p) {
            return 2*p;
        }

    }

    public static void main(String[] args) {
        heapsort hp = new heapsort();
        MyPriorityQueue pq = hp.new MyPriorityQueue();
        int[] arr = new int[]{2,4,1,4,6,7,8,3};
        int n = arr.length;
        doHeapSort(pq, arr, n);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("val is : " + arr[i]);
        }
    }

    static void doHeapSort(MyPriorityQueue p, int[] a, int len) {
        createHeap(p, a, len);
        for (int i = 0; i < len; i++) {
            a[i] = extractMin(p);
        }

    }

    static void createHeap(MyPriorityQueue p, int[] a, int len ) {
        for (int i = 0; i < len; i++) {
            insertinqueue(p ,a[i] );
        }
    }
    static void insertinqueue(MyPriorityQueue p, int a ) {
        p.n = p.n + 1;
        p.q[p.n] = a;
        bubbleUp(p, p.n);
    }

    static int extractMin(MyPriorityQueue p) {
        int min = p.q[1];
        p.q[1] = p.q[p.n];
        p.q[p.n] = 0;
        p.n = p.n -1;
        bubbleDown(p, 1);
        return min;
    }

    static void bubbleUp(MyPriorityQueue p, int pos) {
        int i = pos;
        if (p.getParent(pos) == -1) return;
           if (p.q[p.getParent(pos)] > p.q[pos])  {
               swap(p, p.getParent(pos), pos);
               bubbleUp(p,p.getParent(pos));
           }
       }

    static void swap(MyPriorityQueue p, int x, int y) {
        int temp = 0;
        temp = p.q[x] ;
        p.q[x] = p.q[y];
        p.q[y] = temp;
    }

    static void bubbleDown(MyPriorityQueue p, int pos) {

        if(pos > p.n) return;
        int minpos = pos;
        int child1 = p.getLowerChild(pos);
        for (int i = 0; i <= 1; i++) {
            if(child1 + i <= p.n) {
                if (p.q[child1 + i] < p.q[minpos]) {
                    minpos = child1 + i;
                }
            }
            if (minpos != pos) {
                swap(p, minpos, pos);
                bubbleDown(p, minpos);
            }
        }

    }
}
