/**
 * Created by Priya on 5/4/2016.
 */
public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        public ListNode add(int val) {
            ListNode l = this;
            while(l.next != null)
                l = l.next;
            ListNode n = new ListNode(val);
            n.next = null;
            l.next = n;
            l = l.next;
            return l;
        }

}
