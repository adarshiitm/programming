package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by adarsh.sharma on 20/07/18.
 */
public class FourSum {

    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int target) {
        Collections.sort(A);
        Integer[] num = new Integer[A.size()];
        num = A.toArray(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < num.length; i++) {
            if (i > 0 && num[i].equals(num[i - 1])) {
                continue;
            }
            for (int j = i + 1; j < num.length; j++) {
                if (j > i + 1 && num[j].equals(num[j - 1])) {
                    continue;
                }
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

                        result.add(temp);
                        int prev = num[k];
                        while (k < num.length && num[k].equals(prev)) {
                            k++;
                        }
                        prev = num[l];
                        while (l > k && num[l].equals(prev)) {
                            l--;
                        }
                    }
                }
            }
        }

        return result;
    }

//    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int target) {
//        Collections.sort(A);
//        Integer[] num = new Integer[A.size()];
//        num = A.toArray(num);
//        HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
//        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//
//        for (int i = 0; i < num.length; i++) {
//            for (int j = i + 1; j < num.length; j++) {
//                int k = j + 1;
//                int l = num.length - 1;
//
//                while (k < l) {
//                    int sum = num[i] + num[j] + num[k] + num[l];
//
//                    if (sum > target) {
//                        l--;
//                    } else if (sum < target) {
//                        k++;
//                    } else if (sum == target) {
//                        ArrayList<Integer> temp = new ArrayList<Integer>();
//                        temp.add(num[i]);
//                        temp.add(num[j]);
//                        temp.add(num[k]);
//                        temp.add(num[l]);
//
//                        if (!hashSet.contains(temp)) {
//                            hashSet.add(temp);
//                            result.add(temp);
//                        }
//
//                        k++;
//                        l--;
//                    }
//                }
//            }
//        }
//
//        return result;
//    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
//        A.addAll(Arrays.asList(9, -8, -10, -7, 7, -8, 2, -7, 4, 7, 0, -3, -4, -5, -1, -4, 5, 8, 1, 9, -2, 5, 10, -5, -7, -1, -6, 4, 1, -5, 3, 8, -4, -10,
//                -9, -3, 10, 0, 7, 9, -8, 10, -9, 7, 8, 0, 6, -6, -7, 6, -4, 2, 0, 10, 1, -2, 5, -2));
        A.addAll(Arrays.asList(-1, -1, -1, -1, 0, 0, 0, 0, 1, 1, 1, 1));
        System.out.println(new FourSum().fourSum(A, 0));
    }
}
