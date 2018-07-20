package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by adarsh.sharma on 20/07/18.
 */
public class FourSum {
//    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
//        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
//        Collections.sort(A);
//
//        int sum = 0;
//        for (int i = 0; i < A.size() - 3; i++) {
//            if (i == 0 || A.get(i) != A.get(i - 1)) {
//                for (int j = i + 1; j < A.size() - 2; j++) {
//                    if (j == 1 || A.get(j) != A.get(j - 1)) {
//                        sum = B - A.get(i) - A.get(j);
//                        int s = j + 1;
//                        int e = A.size() - 1;
//                        while (s < e) {
//                            if (sum == A.get(s) + A.get(e)) {
//                                ArrayList<Integer> r = new ArrayList<>();
//                                r.add(A.get(i));
//                                r.add(A.get(j));
//                                r.add(A.get(s));
//                                r.add(A.get(e));
//                                res.add(r);
//                                s++;
//                                e--;
//
//                                while (s <= e) {
//                                    if (A.get(s) == A.get(s - 1)) {
//                                        s++;
//                                    } else {
//                                        break;
//                                    }
//                                }
//                                while (s <= e) {
//                                    if (A.get(e) == A.get(e + 1)) {
//                                        e--;
//                                    } else {
//                                        break;
//                                    }
//                                }
//
//                            } else if (sum < A.get(s) + A.get(e)) {
//                                e--;
//                                while (s <= e) {
//                                    if (A.get(e) == A.get(e + 1)) {
//                                        e--;
//                                    } else {
//                                        break;
//                                    }
//                                }
//                            } else {
//                                s++;
//                                while (s <= e) {
//                                    if (A.get(s) == A.get(s - 1)) {
//                                        s++;
//                                    } else {
//                                        break;
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return res;
//    }

    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int target) {
        Collections.sort(A);
        Integer[] num = new Integer[A.size()];
        num = A.toArray(num);
        HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int k = j + 1;
                int l = num.length - 1;

                while (k < l) {
                    int sum = num[i] + num[j] + num[k] + num[l];

                    if (sum > target) {
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else if (sum == target) {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(num[i]);
                        temp.add(num[j]);
                        temp.add(num[k]);
                        temp.add(num[l]);

                        if (!hashSet.contains(temp)) {
                            hashSet.add(temp);
                            result.add(temp);
                        }

                        k++;
                        l--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.addAll(Arrays.asList(9, -8, -10, -7, 7, -8, 2, -7, 4, 7, 0, -3, -4, -5, -1, -4, 5, 8, 1, 9, -2, 5, 10, -5, -7, -1, -6, 4, 1, -5, 3, 8, -4, -10,
                -9, -3, 10, 0, 7, 9, -8, 10, -9, 7, 8, 0, 6, -6, -7, 6, -4, 2, 0, 10, 1, -2, 5, -2));
        System.out.println(new FourSum().fourSum(A, 0));
    }
}
