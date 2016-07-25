import java.util.ArrayList;
import java.util.List;

/**
 * Created by Priya on 5/9/2016.
 */

public class CreateBalancedTree {

    /**
     * Definition for a binary tree node.**/
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    public static void main(String[] args) {

        ListNode l = new ListNode(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        l.add(6);
        CreateBalancedTree crt = new CreateBalancedTree();
        TreeNode root = crt.sortedListToBST(l);
        crt.inOrderTraversal(root);
    }

    void inOrderTraversal(TreeNode r) {
        if (r.left!=null) {
            inOrderTraversal(r.left);
        }
        System.out.println(r.val);
        if (r.right!=null) {
            inOrderTraversal(r.right);
        }
    }
    public TreeNode sortedListToBST(ListNode head) {
        ListNode left = head;
        ListNode right = head;
        if (head == null) return null;
        int len = 1;
        while(right.next != null) {
            right = right.next;
            len++;
        }
        if (left == right) return new TreeNode(head.val);
        return sortedListToBSTRec(head, 0, len-1);

    }

    TreeNode sortedListToBSTRec(ListNode head, int l, int h) {
        if (l > h) return null;
        ListNode m = head;
        int md =(l+h)/2;
        for (int i = 0; i < md; i++) {
           m = m.next;
        }
        TreeNode  r = new TreeNode(m.val);
        r.left = sortedListToBSTRec(head, l, md - 1);
        r.right = sortedListToBSTRec(head, md +1, h);
        return r;
    }

    public TreeNode sortedArrayToBST(final List<Integer> a) {
        if (a == null || a.size() == 0) return null;
        return buildTreeRec(a, 0 , a.size()-1);
    }
    private TreeNode buildTreeRec (List<Integer> a , int start, int end) {
        if (start > end) return null;
        int maxind = (start + end) /2;
        TreeNode r = new TreeNode(a.get(maxind));
        r.left = buildTreeRec(a, start, maxind-1);
        r.right = buildTreeRec(a, maxind+1,end);
        return r;
    }

}

}
