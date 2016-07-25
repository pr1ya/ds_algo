import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Priya on 5/20/2016.
 */
public class FindIslands {
    public int numIslands(char[][] grid) {
        Queue<Integer> q = new LinkedList<Integer>();
        Stack<Integer> st= new Stack<Integer>();
        int islands = 0;
        int h = grid.length;
        if (h == 0) return 0;
        int w = grid[0].length;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if(grid[i][j] == '1') q.add(i+j+2);
            }
        }
        while (!q.isEmpty()) {
            int pos = q.poll();
            st.push(pos);
            while (!st.isEmpty()) {
                int el = st.pop();
                if (el +1 <= h+w && q.contains(el+1)) {
                    q.remove(el+1);
                    st.push(el+1);
                }
                if (el + w<= h+w && q.contains(el+w)) {
                    q.remove(el+w);
                    st.push(el+w);
                }
            }
        islands++;
        }
        return islands;
    }
}
