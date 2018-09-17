package practice.algo.misc;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

/**
 * Created by adarsh.sharma on 11/06/18.
 */
public class Test {
    class P {
        int x;
        int y;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            P p = (P) o;
            return x == p.x &&
                    y == p.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    public static void main(String[] args) {
        int[] ints = IntStream.range(0, 0).toArray();
        Arrays.stream(ints).forEach(System.out::println);
    }
}


