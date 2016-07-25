import java.util.*;

/**
 * Created by Priya on 5/10/2016.
 */
public class zigzagll {
    Stack<TreeNode> st1 = new Stack<TreeNode>() ;
    Stack<TreeNode> st2 = new Stack<TreeNode>();
    boolean isStackst1Used = true;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ret = new ArrayList<List<Integer>>();
            if (root == null) {
                ret.add(new ArrayList<Integer>());
                return ret;
            } else {
                st1.add(root);
            }

/*            while (!q.isEmpty() || !st.isEmpty()) {
                System.out.println(isStackUsed);
            if (isStackUsed) {
                List<Integer> l1 = new ArrayList<Integer>();
                while (!q.isEmpty()) {
                    TreeNode t = q.poll();
                    l1.add(t.val);
                    if(t.left != null) {
                        st.push(t.left);
                    }
                    if(t.right != null) {
                        st.push(t.right);
                    }
                }
                isStackUsed = false;
                ret.add(l1);

            } else {
                List<Integer> l2 = new ArrayList<Integer>();
                while (!st.isEmpty()) {
                    TreeNode t = st.pop();
                    l2.add(t.val);
                    if(t.left != null) {
                        q.add(t.left);
                    }
                    if(t.right != null) {
                        q.add(t.right);
                    }
                }
                isStackUsed = true;
                ret.add(l2);
            }
        }*/;
            while (!st1.isEmpty() || !st2.isEmpty()) {
                if (isStackst1Used) {
                    List<Integer> l1 = new ArrayList<Integer>();
                    while (!st1.isEmpty()) {
                        TreeNode t = st1.pop();
                        l1.add(t.val);
                        if (t.left != null) {
                            st2.push(t.left);
                        }
                        if (t.right != null) {
                            st2.push(t.right);
                        }
                    }
                    isStackst1Used = false;
                    ret.add(l1);

                } else {
                    List<Integer> l2 = new ArrayList<Integer>();
                    while (!st2.isEmpty()) {
                        TreeNode t = st2.pop();
                        l2.add(t.val);
                        if (t.left != null) {
                            st2.add(t.right);
                        }
                        if (t.right != null) {
                            st2.add(t.left);
                        }
                    }
                    isStackst1Used = true;
                    ret.add(l2);
                }

            }
            return ret;
    }

}
