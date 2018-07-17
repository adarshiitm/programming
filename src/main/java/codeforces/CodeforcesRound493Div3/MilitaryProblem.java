package codeforces.CodeforcesRound493Div3;

import java.util.*;

/**
 * Created by adarsh.sharma on 16/07/18.
 */
public class MilitaryProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        Map<Integer, List<Integer>> parentChildMap = new HashMap<>();
        for (int i = 2; i <= n; i++) {
            int p = sc.nextInt();
            List<Integer> integers = parentChildMap.computeIfAbsent(p, k -> new ArrayList<>());
            integers.add(i);
        }

        Map<Integer, Integer> posMap = new HashMap<>();
        ArrayList<Integer> a = new ArrayList<>();

        inorder(1, parentChildMap, posMap, a);

        for (int i = 0; i < q; i++) {
            Integer integer = posMap.get(sc.nextInt());
            int k = sc.nextInt();
            if ((integer + k - 1) >= a.size()) {
                System.out.println(-1);
            } else {
                System.out.println(a.get(integer + k - 1));
            }
        }
    }

    private static void inorder(int node, Map<Integer, List<Integer>> parentChildMap, Map<Integer, Integer> posMap, ArrayList<Integer> a) {
        if (!posMap.containsKey(node)) {
            posMap.put(node, a.size());
            a.add(node);
        }

        List<Integer> integers = parentChildMap.get(node);
        if (integers != null) {
            for (Integer i : integers) {
                inorder(i, parentChildMap, posMap, a);
            }
        }
    }
}
