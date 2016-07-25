import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Priya on 5/5/2016.
 */
/*public class SortLL {

        public ListNode sortList(ListNode head) {

            ListNode l = head;
            int len = 0;
            while (l != null) {
                len++;
                l = l.next;
            }
            if (len <= 1) return head;
            l = head;
            PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(len, new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    if (o1.val > o2.val)
                        return 1;
                    else if (o1.val < o2.val)
                        return -1;
                    else return 0;
                }
            });
            while (l!= null) {
                pq.add(l);
                l = l.next;
            }

            ListNode m = pq.poll();
            head = m;
            while(!pq.isEmpty()) {
                m.next = pq.poll();
            }
            m.next = null;
            return head;
        }*/
public class SortLL {

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.add(2);
        l.add(2);
        l.add(3);
        l.add(8);
        l.add(4);
        l.add(5);
        l.add(6);
        sortList(l, l.add(6));
    }

    public static  ListNode sortList(ListNode head, ListNode tail) {
        ListNode org = head;
        ListNode newhead = null;
        ListNode newtail = null;
        ListNode head2 = null;
        if (head == tail) return head;
        ListNode pivot = partition(head, tail, newhead, newtail);
        ListNode head1 = sortList(newhead, pivot);
        if (pivot != null) {
            head2 = sortList(pivot.next, newtail);
        }
        org = head1;
        while(head1!=null) head1=head1.next;
        head1.next = pivot;
        pivot.next = head2;
        return org;
    }

    static ListNode partition(ListNode head, ListNode tail, ListNode newhead, ListNode newtail) {
        ListNode pivot = head;
        ListNode temp;
        newhead = pivot;
        if (head!=null && head.next!= null) {
            if (head.next.val < pivot.val) {//
                head.next.next = newhead;
                newhead = head.next;
                head.next = head.next.next;
            } else if (head.next.val == pivot.val) {
                temp = pivot.next;
                pivot.next = head.next;
                head.next = head.next.next;
                pivot.next.next = temp;
            }
            head = head.next;
        }
        newtail = head;
        newtail = head;
        return pivot;
    }
}
