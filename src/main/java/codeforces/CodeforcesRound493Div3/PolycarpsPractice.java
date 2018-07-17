package codeforces.CodeforcesRound493Div3;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by adarsh.sharma on 16/07/18.
 */
public class PolycarpsPractice {
    static class MinHeap {
        int[] arr;
        int[] p;
        int sz = 0;
        int heapSize;

        public MinHeap(int[] p, int k) {
            this.arr = new int[k];
            this.p = p;
            this.heapSize = k;
            for (int i = 0; i < k; i++) {
                arr[i] = i;
            }
            for (int i = arr.length / 2 - 1; i >= 0; i--) {
                minHeapify(i);
            }
            for (int i = k; i < p.length; i++) {
                add(i);
            }
        }

        private void minHeapify(int i) {
            while (true) {
                int l = left(i);
                int r = right(i);
                int smallest = i;
                if (l < heapSize && p[arr[l]] < p[arr[i]]) {
                    smallest = l;
                }
                if (r < heapSize && p[arr[r]] < p[arr[smallest]]) {
                    smallest = r;
                }

                if (smallest != i) {
                    swap(i, smallest);
                    i = smallest;
                } else {
                    break;
                }
            }
        }

        public void add(int v) {
            if(p[v] > p[arr[0]]) {
                arr[0] = v;
                minHeapify(0);
            }
        }

        public int[] getArr() {
            return arr;
        }

        private void swap(int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    private static int left(int i) {
        return 2 * i + 1;
    }

    private static int right(int i) {
        return 2 * i + 2;
    }

    private static int parent(int i) {
        return (i - 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }

        int[] arr = new MinHeap(p, k).getArr();
        List<Integer> lst = Arrays.stream(arr).boxed().sorted().collect(Collectors.toList());

        System.out.println(lst.stream().reduce(0, (a, b) -> a + p[b]));
        lst.set(0, 0);
        lst.add(p.length);
        for (int i = 1; i < lst.size(); i++) {
            System.out.print(lst.get(i) - lst.get(i - 1) + " ");
        }
    }

}

//Working solution
//    static class P implements Comparable<P> {
//        int idx;
//        int val;
//
//        public P(int idx, int val) {
//            this.idx = idx;
//            this.val = val;
//        }
//
//        @Override
//        public int compareTo(P that) {
//            return that.val - this.val;
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//        List<P> plist = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            plist.add(new P(i, sc.nextInt()));
//        }
//
//        Collections.sort(plist);
//
//        List<P> lst = plist.subList(0, k);
//
//        int sum = 0;
//        for (P p : lst) {
//            sum += p.val;
//        }
//        System.out.println(sum);
//        Collections.sort(lst, Comparator.comparingInt(o -> o.idx));
//
//        lst.set(0, new P(0, 0));
//        lst.add(new P(n, 0));
//        for (int i = 1; i < lst.size(); i++) {
//            System.out.print(lst.get(i).idx - lst.get(i - 1).idx + " ");
//        }
//    }
