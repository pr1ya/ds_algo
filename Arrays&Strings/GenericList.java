import java.util.LinkedList;

/**
 * Created by priya on 13-07-2016.
 */
public class GenericList {

    public static void main(String[] args) {
        GenericList gn = new GenericList();
        GenericList.ListNode<Integer> ll = gn.new ListNode<Integer>();
        ll.add(5);
        System.out.println(ll.get());
    }

    class ListNode<T> {
        Node<T> head;

        public ListNode() {
            head = null;
        }

        class Node<T> {
            T t;
            Node next;

            public Node(T t) {
                this.t = t;
                this.next = null;
            }
        }

        public void add(T n) {
            Node<T> nn = new Node<T>(n);
            Node<T> temp = head;
            if (head == null) {
                head = nn;
            } else {
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = nn;
            }
        }

        public T get() {
            return head.t;
        }
    }

}
