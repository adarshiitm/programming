package practice.algo.misc;

/**
 * Created by adarsh.sharma on 11/06/18.
 */
public class Test {
    public static void main(String[] args) {
        String s = "Is Joe the funniest guy? I don't think so. But this is what he thinks.";
        String[] split = s.split(" |\\.|\\?");
        for (String s1 : split) {
            System.out.println(s1);
        }

    }
}
