/**
 * Created by Priya on 6/16/2016.
 */
public class isSymmTree {
    public int isSymmetric(TreeNode a) {
        if(isSymmetricTree(a.left, a.right)) return 1;
        return 0;
    }

    boolean isSymmetricTree(TreeNode a, TreeNode b) {
        if(a == null && b == null) return true;
        if(a == null || b == null) return false;

        return (isSymmetricTree(a.left,b.right) && isSymmetricTree(a.right,b.left) && a.val == b.val);
    }

}
    public int minDepth(TreeNode a) {
       if(a == null) return 0;
        if (a.left == null && a.right == null) return 1;
        if(a.left == null) return minDepthRec(a.right);
        if(a.right == null) return minDepthRec(a.left);
        return minDepthRec(a);
    }

    int minDepthRec(TreeNode a) {
        if (a==null) return 0;
        return Math.min(1+minDepth(a.left), 1+minDepth(a.right));
    }

}


