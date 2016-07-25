import java.util.Comparator;
import java.util.MissingResourceException;
import java.util.PriorityQueue;

/**
 * Created by Priya on 5/4/2016.
 */
public class Mergeksorts {
    public static  class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x;
        }
    }

    static ListNode addNode(int x, ListNode l) {
        ListNode node = new ListNode(x);
        while(l.next != null) {
            l = l.next;
        }
        node.next = null;
        l.next = node;
        return node;
    }

    public static void main (String[] args) {
        Mergeksorts m = new Mergeksorts();
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode[] list = new ListNode[2];

        addNode(4, l1);
        addNode(5, l2);
        int len = list.length;

        PriorityQueue<ListNode> pq= new PriorityQueue<ListNode>(len, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val > o2.val)
                    return 1;
                else if (o1.val == o2.val)
                    return 0;
                 else return -1;
            }
        });

        if (list.length == 0) return;
        ListNode l = createList(pq, list);
        while(l != null) {
            System.out.println("sorted list: " + l.val);
            l = l.next;
        }

    }

    static ListNode createList(PriorityQueue<ListNode> pq, ListNode[] list) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null)
                pq.add(list[i]);
        }
        ListNode head = new ListNode(0);
        ListNode res = head;

        while (pq.size() > 0) {
            ListNode temp = pq.poll();
            res.next = temp;
            res = res.next;
            if (temp.next != null) {
                pq.add(temp);
                temp = temp.next;

            }
        }

        return head.next;
    }


}
