package practice.algo.misc;

import java.util.*;

/**
 * Created by adarsh.sharma on 11/06/18.
 */
public class Test {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(3);
        System.out.println(st.pop());
        System.out.println(st.peek());

        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(3);
        System.out.println(q.size());
        System.out.println(q.peek());
        System.out.println(q.poll());
        System.out.println(q.peek());
    }
}
