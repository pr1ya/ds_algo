import java.util.ArrayList;

/**
 * Created by Priya on 6/16/2016.
 */
public class traversal {
    public ArrayList<Integer> inorderTraversal(TreeNode a) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        doInorderTraversal(a, arr);
        return arr;
    }
    void doInorderTraversal(TreeNode a,  ArrayList<Integer> arr) {
        if (a == null) return;
        doInorderTraversal(a.left,arr);
        arr.add(a.val);
        doInorderTraversal(a.right,arr);
    }
}
