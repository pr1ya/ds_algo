import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Priya on 6/16/2016.
 */
public class isSameTree {
    public int isSameTree(TreeNode a, TreeNode b) {
    ArrayList<Integer> preA = inorderTraversal(a);
        ArrayList<Integer> preB = inorderTraversal(b);
        if (preA.size() != preB.size()) return 0;
        for (int i = 0; i < preA.size() ; i++) {
            if (preA.get(i).intValue() != preB.get(i).intValue()) return 0;
        }
        preA = preorderTraversal(a);
        preB = preorderTraversal(b);
        if (preA.size() != preB.size()) return 0;
        for (int i = 0; i < preA.size() ; i++) {
            if (preA.get(i).intValue() != preB.get(i).intValue()) return 0;
        }

        return 1;
    }
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

    public ArrayList<Integer> preorderTraversal(TreeNode a) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        dopreorderTraversal(a, arr);
        return arr;
    }
    void dopreorderTraversal(TreeNode a,  ArrayList<Integer> arr) {
        if (a == null) return;
        dopreorderTraversal(a.left, arr);
        arr.add(a.val);
        dopreorderTraversal(a.right, arr);
    }

}
