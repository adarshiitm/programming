package practice.algo.misc;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by adarsh.sharma on 11/06/18.
 */
public class Test {
    public static void main(String[] args) {
        String a = "  123   456   789";
        String[] s = a.trim().split("\\s+");
        Collections.reverse(Arrays.asList(s));
        System.out.println(String.join(" ", s));
    }
}
