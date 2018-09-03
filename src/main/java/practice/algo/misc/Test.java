package practice.algo.misc;

import java.util.Arrays;

/**
 * Created by adarsh.sharma on 11/06/18.
 */
public class Test {

    public static void main(String[] args) {
        int[] a = {1,3,4,7,9};
        System.out.println(Arrays.binarySearch(a, 0, a.length, 4));
        System.out.println(Arrays.binarySearch(a, 0, a.length, 8));
    }
}
