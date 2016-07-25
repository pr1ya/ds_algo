/**
 * Created by Priya on 5/11/2016.
 */
public class RandomListNode {

         int label;
         RandomListNode next, random;
         RandomListNode(int x) { this.label = x; }
    public static void main() {

    }


   /* public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode h1 = head;
        RandomListNode h2 = head;;
        RandomListNode newlist1,newlist2, newlist3;
        if (head == null)  return head;

        RandomListNode newlist = new RandomListNode(h1.label);
        newlist.next = null;
        newlist.random = null;
        newlist1 = newlist;
        newlist2 = newlist;
        newlist3 = newlist;
        h1 = h1.next;

        while(h1 != null) {
            RandomListNode temp = new RandomListNode(h1.label);
            temp.next = null;
            temp.random = null;
            newlist.next = temp;
            newlist = temp;
            h1 = h1.next;
        }

        while (newlist2 != null) {
            System.out.println(newlist2.label);
            newlist2 = newlist2.next;
        }
        while(h2 != null &&newlist1!= null) {
            RandomListNode r = newlist3;
            RandomListNode rorg = head;
            if (h2.random == null) {
                h2 = h2.next;
                newlist1 = newlist1.next;
                continue;
            }
            while (rorg.next != null) {
                if (rorg.next == h2.random) {
                    newlist1.random = r.next;
                    h2 = h2.next;
                    newlist1 = newlist1.next;
                    break;
                } else {
                   r = r.next;
                   rorg = rorg.next;
                }
            }
            h2 = h2.next;
            newlist1 = newlist1.next;
        }
        return newlist3;
    }
*/

    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode h1 = head;
        RandomListNode h2 = head;;
        RandomListNode newlist1,newlist2, newlist3;
        if (head == null)  return head;

        RandomListNode newlist = new RandomListNode(h1.label);
        newlist.next = null;
        newlist.random = null;
        newlist1 = newlist;
        newlist2 = newlist;
        newlist3 = newlist;
        h1 = h1.next;

        while(h1 != null) {
            RandomListNode temp = new RandomListNode(h1.label);
            temp.next = null;
            temp.random = h1;
            newlist1.next = temp;
            newlist1 = newlist1.next;
            h1 = h1.next;
        }

        h1 = head;
        newlist1 = newlist;

        while(h1 != null) {
            RandomListNode temp = h1;
            h1 = h1.next;
            temp.random = newlist1;
            newlist1 = newlist1.next;
        }

        h1 = head;
        newlist1 = newlist;

        while (newlist1 != null) {
            RandomListNode temp = newlist1;
            newlist1 = newlist1.next;
            if (temp.random.random == null) {
                temp.random = null;
            } else {
                temp.random = temp.random.random.next;
            }
        }
        return newlist;
    }
}
