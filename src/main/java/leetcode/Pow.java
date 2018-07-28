package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by adarsh.sharma on 28/07/18.
 */
public class Pow {
    Map<Long, Double> pMap = new HashMap<>();
    public double myPow(double x, int n) {
        if(n<0) {
            double d = 1;
            return d/myPow(x, -n);
        }

        pMap.put(0L, 1.0);
        pMap.put(1L, x);
        for(long i=1;i<32;i++) {
            pMap.put(1L<<i, pMap.get(1L<<(i-1))*pMap.get(1L<<(i-1)));
        }

        double res = 1;

        long i=0;
        while(n > 0) {
            if((n & 1) > 0) {
                res*=pMap.get(1<<i);
            }
            n = n>>1;
            i++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Pow().myPow(2.0, 10));
    }
}
