import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Priya on 5/11/2016.
 */
public class serializeDeserialize {

        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) { val = x; }
        }

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root == null) return null;
            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> q = new LinkedList<TreeNode>();
            q.add(root);
            while (!q.isEmpty()) {
                TreeNode t = q.poll();
                if (t == null) {
                    sb.append('#');
                }else {
                    q.add(t.left);
                    q.add(t.right);
                    sb.append(t.val);
                }
            }
            return sb.toString();
        }


        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null) return null;
            System.out.println(data);
            return recurse(data, 0);
        }

        public TreeNode recurse(String data ,int end) {
            if (end >= data.length()) return null;
            if (data.charAt(end) == '#') {
                return null;
            }
            TreeNode t = null;
            if (data.charAt(end) == '-') {
                t = new TreeNode(data.charAt(++end) - '0');
            } else {
                t = new TreeNode(data.charAt(end) - '0');
            }
            t.left = recurse(data,2*end + 1);
            t.right = recurse(data, 2*end + 2);

            return t;
        }



}

