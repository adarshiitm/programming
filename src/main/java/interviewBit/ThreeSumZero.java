package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by adarsh.sharma on 23/07/18.
 */
public class ThreeSumZero {
    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(a==null) {
            return res;
        }

        Collections.sort(a);
        int n = a.size();
        for(int i=0;i<n-2;i++) {
            if(i==0 || !a.get(i).equals(a.get(i-1))) {
                int first = a.get(i);
                int s = i+1;
                int e = n-1;
                while(s<e) {
                    int second = a.get(s);
                    int third = a.get(e);
                    int sum = first+second+third;

                    if(sum == 0) {
                        add(res, first, second, third);
                        s++;
                        while(s<n-1) {
                            if(a.get(s).equals(a.get(s-1))) {
                                s++;
                            } else {
                                break;
                            }
                        }
                        e--;
                        while(e>i) {
                            if(a.get(e).equals(a.get(e+1))) {
                                e--;
                            } else {
                                break;
                            }
                        }
                    } else if(sum < 0) {
                        s++;
                    } else {
                        e--;
                    }
                }
            }
        }

        return res;
    }

    private void add(ArrayList<ArrayList<Integer>> res, int a, int b, int c) {
        ArrayList<Integer> r = new ArrayList<>();
        r.add(a);
        r.add(b);
        r.add(c);
        res.add(r);
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.addAll(Arrays.asList(-31013930, -31013930, 9784175, 21229755));
        System.out.println(new ThreeSumZero().threeSum(a));
    }
}
