import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Priya on 5/17/2016.
 */
public class CreateIPAddresses {
    List<String> ips;
    public List<String> restoreIpAddresses(String s) {
        ips = new ArrayList<String>();
        int[] a = new int[3];
        int[]nums = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            nums[i] = Integer.valueOf(s.charAt(i));
        }
        BackTrack(a, -1, nums);
        return ips;
    }

    public void BackTrack(int[] a, int k, int[] nums) {
        int[] c = new int[3];
        int nc = 0;
        if (k == 3) {
            //process solution
        } else {
            k = k +1;
           nc =  constructCandidates(a, c, k, nums);
            for (int i = 0; i < k; i++) {

            }
        }
    }

    public int constructCandidates(int[] a, int[] c, int k, int[] nums) {
        int pos = 0;
        if(k > 0) {
            pos = a[k] + 1;
        }
        int rem = nums.length  - pos;
       // int maxlen =
        return 0;
    }
    public int threeSumClosest(ArrayList<Integer> a, int b) {
        Collections.sort(a);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < a.size()-2; i++) {
            int c = a.get(i);
            int j = i+1;
            int k = a.size()-1;
            while (j<k) {
                int sumdiff = c + a.get(j).intValue() + a.get(k).intValue() - b;
                if (Math.abs(sumdiff) < Math.abs(minDiff)) {
                    minDiff = sumdiff;
                }
                if (sumdiff > 0) {
                    k--;
                } else if (sumdiff < 0) {
                    j++;
                } else {
                    System.out.println(c + a.get(j).intValue() + a.get(k).intValue());
                    return 0;
                }
            }
        }
        return minDiff;
    }
    public int removeDuplicates(ArrayList<Integer> a) {
        int len = 0;
        for (int i = 0; i < a.size()-1;i++) {
            len++;
            if (a.get(i).equals( a.get(i+1))){
            len--;
            }
        }
        return len;
    }
    public int removeDuplicates(ArrayList<Integer> a) {
        for (int i = 0; i < a.size()-1;) {
            if (a.get(i).equals( a.get(i+1))){
                a.remove(i);
            } else {
                i++;
            }
        }
        return a.size();
    }
    public int removeElement(ArrayList<Integer> a, int b) {
        int j = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < a.size() ; i++) {
            if (a.get(i).intValue() == b) {
                q.add(i);
                continue;
            } else {
                if (!q.isEmpty()) {
                    int p = q.poll();
                    a.set(p, a.get(i).intValue());
                    a.set(i, b);
                    i--;
                }
            }
        }
            if (!q.isEmpty()) return q.poll();
            else return a.size();
    }
    public int removeElement(ArrayList<Integer> a, int b) {
        int j = 0;
      //  Queue<Integer> q = new LinkedList<Integer>();
        int q = -1;
        for (int i = 0; i < a.size() ; i++) {
            if (a.get(i).intValue() == b) {
                if (q > i)
                q = i;
                continue;
            } else {
                if (q != -1) {
                    int p = q;
                    a.set(p, a.get(i).intValue());





                    a.set(i, b);
                    q = i;
                }
            }
        }
        if (q!=-1) return q;
        else return a.size();
    }

    public ArrayList<Integer> maxone(ArrayList<Integer> a, int b) {
        int currstart,currstop, beststart,beststop;
        currstart=currstop= beststart=beststop = 0;
        int k = 0;
        while (currstop < a.size()) {
            if((a.get(currstop) == 0 && b-k>0)) {
                k++;
                currstop++;
            } else if(a.get(currstop) ==1) {
                currstop++;
            } else if(a.get(currstop) == 0 && b-k ==0) {
                if (beststop-beststart < currstop-currstart) {
                    beststop = currstop;
                    beststart = currstart;
                }
                while(a.get(currstart) != 0 && currstart <= currstop) {
                    currstart++;
                }
                if(a.get(currstart) == 0) {
                    k--;
                }
            }
        }
        if (beststop-beststart < currstop-currstart) {
            beststop = currstop;
            beststart = currstart;
        }

        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = beststart; i <= beststop; i++) {
            res.add(i);
        }
        return res;
    }

    public ArrayList<Integer> findSubstring(String a, final List<String> b) {
        int start , end;
        start = end = 0;
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (b == null || b.size() == 0) return null;
        int wordlen = b.get(0).length();
        HashMap<String, Integer> hm = createHashMap(b);
        int i = 0;
        while (end < a.length() && start < a.length() && i <= a.length()-wordlen) {
            String curr = a.substring(i, i + wordlen - 1);
            if (hm.containsKey(curr)) {
                start = i;
                while (!hm.isEmpty() && hm.containsKey(curr)) {
                    if ((hm.get(curr).intValue()) > 1) {
                        hm.put(curr, hm.get(curr).intValue() - 1);
                    } else {
                        hm.remove(curr);
                    }
                    i = i + wordlen;
                    end = wordlen - 1;
                    if (i <= a.length()-wordlen)
                       curr = a.substring(i, i + wordlen-1);
                    else break;
                }
                if (hm.isEmpty()) {
                    res.add(start);
                 //   start = end + 1;
                } else {
                    hm.clear();
                    hm = createHashMap(b);
                    i = i-wordlen+1;
                    //  start = end+1;
                }
            }
            i++;
        }
        return res;
    }

    HashMap<String, Integer> createHashMap(List<String>  b) {
        HashMap<String, Integer> hmap = new HashMap<String,Integer>();
        Iterator<String> it = b.listIterator();
        while (it.hasNext()) {
            String st = it.next();
            if (hmap.containsKey(st)) {
                hmap.put(st, (hmap.get(st).intValue() + 1));
            } else {
                hmap.put(st, 1);
            }
        }
        return hmap;
    }
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        HashMap<Integer,Integer> hm = new   HashMap<Integer,Integer>();
        ArrayList<Integer> list = new ArrayList<>();
        if(A.size() < B) return null;
        int i;
        for ( i = 0; i < B; i++) {
            int num = A.get(i);
            if(hm.containsKey(num)) {
                hm.put(num, hm.get(num).intValue() + 1);
            } else {
                hm.put(num, 1);
            }
           // System.out.println("putting");
        }
        int start = 1;
        list.add(hm.size());
        System.out.println(hm.size());
        for (; start <= A.size()-B ; start++) {
            int num = A.get(i++);
            if(hm.containsKey(num)) {
                hm.put(num, hm.get(num).intValue() + 1);
            } else {
                hm.put(num, 1);
            }
            num = A.get(start);
            if (hm.get(num) > 1) hm.put(num,hm.get(num).intValue()-1);
            else hm.remove(num);
            System.out.println(hm.size());
            list.add(hm.size());
        }
        return list;
    }
    public class Solution {
        public class lrulist {
            int key;
            int val;
            lrulist prev;
            lrulist next;

            public lrulist(int k, int v) {
                key = k;
                val = v;
                prev = next = null;
            }
        }
        int maxsize;
        lrulist head;
        lrulist tail;
        int size;
        public Solution(int capacity) {
            maxsize = capacity;
            head = null;
            tail = null;
            size = 0;
        }

        public int get(int key) {
            lrulist hd = head;
            int ret = -1;
            while (hd != null) {
                if (hd.key == key) {
                    ret = hd.val;
                    if (head != hd) {
                        moveToHead(hd);
                    }
                    break;
                }
                hd = hd.next;
            }
            // System.out.println("returning " + ret);
            return ret;
        }

        public void moveToHead(lrulist hd) {
            lrulist p = hd.prev;
            lrulist n = hd.next;

            if (n != null) {
                n.prev = p;
                p.next = n;
            } else {
                p.next = null;
                tail = p;
            }
            addToHead(hd);

        }

        public void set(int key, int value) {
            if (get(key) != -1) {
                head.val = value;
                return;
            }
            lrulist l = new lrulist(key,value);
            //    System.out.println("setting");
            if (maxsize == 1) {
                head = tail = l;
                //   System.out.println("setting end1");
                return;
            }

            if (head == null) {
                head = tail  = l;
                size++;
            } else {
                if (size < maxsize) {
                    addToHead(l);
                    size++;
                } else {
                    removeFromtail();
                    addToHead(l);
                }
            }
            //   System.out.println("setting end2");
        }

        private void addToHead(lrulist l) {
            l.next =head;
            head.prev = l;
            head = l;
        }

        private void removeFromtail() {
            tail = tail.prev;
            tail.next = null;

        }
    }
}

}
