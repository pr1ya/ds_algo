import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Priya on 5/4/2016.
 */
public class removedDups {

    public static void main (String[] args) {
      ListNode l = new ListNode(1);
        l.add(2);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(4);
        l.add(5);
        l.add(6);
        l.add(6);
        ListNode head = removeDupes(l);
        System.out.println("starting");
        while(head!=null) {
            System.out.println(head.val);
            head = head.next;
        }

    }


    public static ListNode removeDupes(ListNode head) {
        Stack<ListNode> st = new Stack<ListNode>();
        ListNode head2 = null;
        ListNode res = null;
        while(head != null) {
           if(!st.isEmpty()&& st.peek() != null && st.peek().val!= head.val) {
               if (st.size() > 1) {
                   st.clear();
               } else {
                   if (head2 == null) {
                       head2 = new ListNode(st.pop().val);
                       head2.next = null;
                       res = head2;
                   } else {
                       res.next = st.pop();
                       res = res.next;
                       res.next = null;
                   }
               }
           }
            st.add(head);
            head = head.next;
        }
        if(!st.isEmpty() && st.size() == 1) {
            if (res != null) {
                res.next = st.pop();
                res = res.next;
                res.next = null;
            } else {
                return st.pop();
            }
        }
        //System.out.println("size of stack is : " + st.size());
        return head2;
    }
}
