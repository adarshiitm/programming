package practice.algo.misc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by adarsh.sharma on 11/06/18.
 */
public class Test {
    public static void main(String[] args) {
        Set<Integer> s = new HashSet<>();
        s.add(0);
        s.add(0);
        List<Integer> l = new ArrayList<>(s);
        System.out.println(l);
    }
}
