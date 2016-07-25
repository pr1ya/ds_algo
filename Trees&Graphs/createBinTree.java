import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Priya on 6/20/2016.
 */
public class createBinTree {
    public TreeNode buildTree(ArrayList<Integer> a) {
        if (a == null || a.size() == 0) return null;
        TreeNode r  = buildTreeRec(a, 0, a.size()-1);
        return r;
    }

    private TreeNode buildTreeRec (ArrayList<Integer> a , int start, int end) {
        if (start > end) return null;
        int maxind = findMax(a, start, end);
        TreeNode r = new TreeNode(a.get(maxind));
        r.left = buildTreeRec(a, start, maxind-1);
        r.right = buildTreeRec(a, maxind+1,end);
        return r;
    }

    private int findMax(ArrayList<Integer> a , int start, int end){
        int max = start;
        int i = start;
        while (i <= end) {
            if (a.get(max) < a.get(i))
                max = i;
            i++;
        }
        return max;
    }

    private TreeNode buildTreeRec2 (ArrayList<Integer> a , int start, int end) {
        if (start > end) return null;
        int mid = (start + end)/2;
        TreeNode r = new TreeNode(a.get(mid));
        r.left = buildTreeRec(a, start, mid-1);
        r.right = buildTreeRec(a, mid+1,end);
        return r;
    }

    public TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {
        if (preorder == null || preorder.size() == 0) return null;
        TreeNode tr = new TreeNode(inorder.get(0));
        int mid = preorder.indexOf(inorder.get(0));
        tr.left = buildTreeRec2(inorder, 0, mid-1);
        tr.right = buildTreeRec2(inorder,mid+1,inorder.size()-1);
        return tr;
    }
}
}
