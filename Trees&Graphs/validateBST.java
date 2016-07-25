/**
 * Created by Priya on 5/10/2016.
 */
public class validateBST {

        static int pval = Integer.MIN_VALUE;
    static boolean res = true;
        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) { val = x; }
        }
        public boolean isValidBST(TreeNode root) {
            doInorder(root);
            return res;

        }

        boolean doInorder(TreeNode r) {
            boolean ret = true;
            if (r.left != null)
               if (!doInorder(r.left)) return  false;
            System.out.println(r.val);
            if ((long)pval > (long)r.val) {
                ret =  false;
            } else {
                pval = r.val;
                ret = true;
            }
            if(r.right != null)
                if (!doInorder(r.left)) return  false;
            return ret;
        }

}
