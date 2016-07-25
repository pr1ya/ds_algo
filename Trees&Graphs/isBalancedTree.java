/**
 * Created by Priya on 6/16/2016.
 */
public class isBalancedTree {
    int Balance =1;
    public int isBalanced(TreeNode a) {
        height(a);
        return Balance;

    }

    int height (TreeNode a) {
        if (a==null) return 0;
        int heightLeft = 1 + height(a.left);
        int heightright = 1+height(a.right);
        if (Math.abs(heightLeft-heightright)>1) Balance = 0;
        return Math.max(heightLeft,heightright);
    }

}
