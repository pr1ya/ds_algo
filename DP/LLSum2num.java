/**
 * Created by Priya on 4/15/2016.
 */
public class LLSum2num {


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean carry = false;
        int tmp;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                ListNode n = new ListNode(0);

            }
            tmp = l1.val + (l2 != null? l2.val : 0) + (carry==true? 1 : 0);
            if (tmp > 9) {
                l1.val = tmp%10;
                carry = true;
            } else {
                l1.val = tmp;
                carry = false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1;
   }
}
