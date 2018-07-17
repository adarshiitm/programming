package codeforces.CodeforcesRound493Div3;

import java.util.*;

/**
 * Created by adarsh.sharma on 16/07/18.
 */
public class XORPaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long k = sc.nextLong();
        List<Map<Long, Long>> mpArray = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            mpArray.add(new HashMap<>());
        }
        mpArray.get(0).put(sc.nextLong(), 1L);

        int j = 1;
        for (int i = 0; i < n; i++) {
            for (; j < m; j++) {
                long cur = sc.nextLong();
                Map<Long, Long> map = mpArray.get(j);
                Map<Long, Long> newmp = new HashMap<>();
                for (Long key : map.keySet()) {
                    newmp.put(key ^ cur, map.get(key));
                }
                if (j > 0) {
                    map = mpArray.get(j - 1);
                    for (Long key : map.keySet()) {
                        long key1 = key ^ cur;
                        newmp.put(key1, map.get(key) + newmp.getOrDefault(key1, 0L));
                    }
                }

                mpArray.set(j, newmp);
            }
            j = 0;
        }

        if (mpArray.get(mpArray.size() - 1).get(k) != null) {
            System.out.println(mpArray.get(mpArray.size() - 1).get(k));
        } else {
            System.out.println(0);
        }
    }
}
