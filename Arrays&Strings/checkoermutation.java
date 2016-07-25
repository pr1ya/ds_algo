import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Priya on 5/2/2016.
 */
public class checkoermutation {
/*
    private String a;
    private String b;*/

    public static void main (String[] args) {
        String a = new String ("priya");
        String b = new String ("priya");
        checkpermute(a, b);
    }

    private static void checkpermute(String x, String y) {

            Arrays.sort(x.toCharArray());
            Arrays.sort(y.toCharArray());
        if (x.equals(y)) {
            System.out.println("same!!");
        }else {
            System.out.println("different!!");
        }
    }

}
