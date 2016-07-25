import java.util.LinkedList;

/**
 * Created by Priya on 5/10/2016.
 */
public class reverseksizeLL {

    ListNode finalval = null;
    boolean f = true;
    /*public ListNode reverseKGroup(ListNode head, int k) {
        ListNode l = head;
        if (k <= 1 || head == null || head.next == null) return head;

        while (head.next != null) {
            ListNode h1 = head;
            ListNode h2 = head;
            ListNode lst = null;
            int t = k;
            while (h2.next != null && t > 1) {
                h2 = h2.next;
                head = head.next;
            }
            if (t == 1) {
                ListNode temp = h2;
                h2 = h2.next;
                head = head.next;
                temp.next = null;
                lst = reverse(h1);
                lst.next = h2;

            }
        }
        return finalval;
    }*/

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null || head.next == null) return head;
        ListNode l = head;
        ListNode h2 = head;
        ListNode h1 = head;
        ListNode lst = null;
        int t = k;
        while (h2.next != null && t > 1) {
            h2 = h2.next;
            head = head.next;
        }
        if (t == 1) {
            ListNode temp = h2;
            h2 = h2.next;
            head = head.next;
            temp.next = null;
            lst = reverse(h1);
            lst.next = reverseKGroup(h2, k);
        }
        return lst;
    }

    ListNode reverse(ListNode ll) {
        if (ll == null || ll.next == null) return ll;
        ListNode curr = ll;
        ListNode prev = null;

        while (curr!=null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;

        }
        if (f) {
            f= false;
            finalval = prev;
        }
        System.out.println(finalval.val);
        System.out.println(ll.val);
        return ll;
    }

}
