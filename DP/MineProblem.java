/**
 * Created by Priya on 3/8/2016.
 */
public class MineProblem {
    Node[] mNodes;
    Node n;
    int numV;
    int numE;
    static int budget;
     int max = -1000;
  //  int cost = 0;

    public static void main(String[] args) {

        MineProblem mn = new MineProblem();
        mn.numV = 15;
        mn.numE  =14;
        mn.budget = 400;
        mn.max = 1;
        mn.mNodes = new Node[mn.numV];
        mn.addEdge(0,1,193,1);
        mn.addEdge(1,2,12,5);
        mn.addEdge( 1, 3, 150, 12);
        mn.addEdge(3 ,4, 27, 36);
        mn.addEdge(3, 5, 23, 43);
        mn.addEdge(0, 6, 145, 40);
        mn.addEdge(6, 7 ,4, 1);
        mn.addEdge(6, 8, 30, 3);
        mn.addEdge(6 ,9, 78, 4);
        mn.addEdge(9 ,10, 30, 20);
        mn.addEdge(9, 11 ,57, 19);
        mn.addEdge(0 ,12, 132, 14);
        mn.addEdge(12 ,13, 21 ,15);
        mn.addEdge(12, 14, 48, 10);
        System.out.println("starting ");
        int total = 0;
        for (int i  = 0; i < 15; i++) {
           // Node n = new Node();
            mn.n = mn.mNodes[i];
            while (mn.n != null) {
                System.out.println("next is : " + mn.n.val);
                total += mn.n.diamonds;
                mn.n = mn.n.next;
            }
        }
        System.out.println("total is : " + total);
        int ans = mn.recurse(0);
        System.out.println("answer is : " + ans);

    }

    public int recurse(int i) {
        if (budget < 0) return -100000;
        if (budget == 0) return 0;

        Node node = mNodes[i];
      //
        int cost = 0;
      //      budget = 400;
        while (node != null) {
            System.out.println("present node is : " + node.val);
        budget -= node.weight;
        max = Math.max(max, node.diamonds + recurse(node.val));
         //   System.out.println("present max is : " + max);
        cost += max;
            System.out.println("present cost is bud is  : " + cost + " " + budget);
        node = node.next;
        }

        return cost;
    }

    public class Node {
        int val;
        int weight;
        int diamonds;
        Node next;
    }

    public void addEdge(int oldval, int v, int w, int d) {
        Node n = new Node();
        n.val = v;
        n.diamonds = d;
        n.weight = w;
        n.next =  mNodes[oldval];
        mNodes[oldval] = n;
    }
}
