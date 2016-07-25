/**
 * Created by Priya on 6/16/2016.
 */
public class invertTree {
    public TreeNode invertTree(TreeNode root) {
        invertTreeRep(root);
        return root;
    }

    public void invertTreeRep(TreeNode r) {
        int temp = 0;
        if (r.right != null && r.left != null) {
            temp = r.left.val;
            r.left.val = r.right.val;
            r.right.val = temp;
        }
        if (r.left != null)
            invertTree(r.left);
        if (r.right != null)
            invertTree(r.right);
    }
}
