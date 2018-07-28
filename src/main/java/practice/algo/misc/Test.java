package practice.algo.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adarsh.sharma on 11/06/18.
 */
public class Test {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add(1 + "");
        a.add(2 + "");
        a.add(3 + "|n");
        System.out.println(a.toString());
        String[] strs = a.toString().split(",");

        strs[0] = strs[0].replace("[", "");
        strs[strs.length -1] = strs[strs.length -1].replace("]", "");
        for (String str : strs) {
            System.out.println(str);
        }
    }
}
