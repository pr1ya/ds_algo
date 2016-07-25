/**
 * Created by Priya on 5/9/2016.
 */
public class ReorderLL {
    static  ListNode p;
    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        l.add(6);
        p = l;
        ListNode q = l;
        reorderList(l);
        while (q != null) {
            System.out.println(q.val);
            q = q.next;
        }
    }

    public static boolean reorderList(ListNode head) {
        if (head == null ) return false;

        if(reorderList(head.next))
            return true;

        if (p == head || p.next == head) {
            head.next = null;
            return true;
        }

        ListNode temp = p;
        p = p.next;
        temp.next = head;
        head.next = p;
        return false;
    }

/*    public static ListNode recurseLL(ListNode head) {
        if (head == null || head.next == null || p == null || p.next == null) return head;
        ListNode ret = recurseLL(head.next);
        if (p == null || p.next == null) return null;
        ListNode temp = p.next;
        p.next = ret;
        p = p.
        return p;

    }*/
}
