package practice.algo.misc;

import java.util.*;

/**
 * Created by adarsh.sharma on 11/06/18.
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(8);
        list.add(6);
        list.add(2);
        System.out.println(Collections.binarySearch(list, 11, Collections.reverseOrder()));
    }
}
