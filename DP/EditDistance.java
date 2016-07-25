/**
 * Created by Priya on 3/3/2016.
 */

/*Convert String str1 into str2 with minimum operations.
Weightage of each operation:
insert :1
delete:1
replace:1*/

public class EditDistance {
    int ret;
    int insertCost, deleteCost, replaceCost;

    public static void main(String[] args) {
        String str1 = new String("abcd");
        String str2 = new String("absd");

        EditDistance ed = new EditDistance();
        ed.ret = 0;
        ed.deleteCost = 1;
        ed.insertCost = 1;
        ed.replaceCost = 4;
        ed.callRecurse(str1, str2, str1.length() , str2.length());
        System.out.println("ret is : " + ed.ret);

    }

    public int callRecurse(String a, String b, int x, int y)  {
        if (x == 0) return y;
        if (y == 0) return x;
        if (a.charAt(x-1) == b.charAt(y-1)) return callRecurse(a,b,x-1,y-1);
        ret = Math.min(Math.min(insertCost + callRecurse(a, b, x-1, y),deleteCost +  callRecurse(a,b,x,y-1)),replaceCost + callRecurse(a,b,x-1,y-1));
        return ret;
    }
}
