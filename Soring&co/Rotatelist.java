/**
 * Created by Priya on 5/5/2016.
 */
public class Rotatelist {

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.add(2);
 /*       l.add(2);
        l.add(3);
        l.add(4);
        l.add(4);
        l.add(5);
        l.add(6);
        l.add(6);*/
        int k = 3;
        ListNode head = rotateRight(l, 1);
        System.out.println("starting");
        while(head!=null) {
            System.out.println(head.val);
            head = head.next;
        }

    }
    public static ListNode rotateRight(ListNode head, int k) {
        //traverse and find length;
        //move to length - k;
        //move length - k end link to point to head;
        int len = 0;
        ListNode l = head;
        while (l != null) { //find length
            len++;
            l = l.next;
        }
        System.out.println("length is : " + len);
        l = head;
        if (len - k < 0)
            k = k%len;
        if (len == k) return head;
        int i = 0;
        while (i<len-k-1) {
            l = l.next;
            i++;
        }
        ListNode newHead = l.next;
        ListNode finalhead = newHead;
        l.next = null;
        while (newHead.next != null) {
            newHead = newHead.next;
        }
        newHead.next = head;

        return finalhead;
    }
}
