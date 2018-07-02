package leetcode;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Created by adarsh.sharma on 18/06/18.
 */
class ExamRoom855 {
    PriorityQueue<PQ> pq;
    int N;

    public ExamRoom855(int N) {
        this.N = N;
        pq = new PriorityQueue<>(N);
    }

    public int seat() {
        if (pq.size() == 0) {
            pq.add(new PQ(0, N - 1, true, false));
            return 0;
        }

        PQ remove = pq.remove();

        if (remove.e && remove.s) {
            int diff = remove.end - remove.start;
            int cur = diff / 2 + remove.start;
            pq.add(new PQ(remove.start, cur, true, true));
            pq.add(new PQ(cur, remove.end, true, true));
            return cur;
        } else if (remove.s) {
            remove.e = true;
            pq.add(remove);
            return remove.end;
        } else {
            remove.s = true;
            pq.add(remove);
            return remove.start;
        }
    }

    public void leave(int p) {
        Iterator<PQ> iterator = pq.iterator();
        PQ first = null;
        PQ second = null;

        while ((first == null || second == null) && iterator.hasNext()) {
            PQ next = iterator.next();
            if (next.end == p) {
                first = next;
            } else if (next.start == p) {
                second = next;
            }
        }

        if (first != null && second != null) {
            pq.remove(first);
            pq.remove(second);
            pq.add(new PQ(first.start, second.end, first.s, second.e));
        } else if (first != null) {
            pq.remove(first);
            first.e = false;
            pq.add(first);
        } else if (second != null) {
            pq.remove(second);
            second.s = false;
            pq.add(second);
        }
    }

    class PQ implements Comparable<PQ> {
        int start;
        int end;
        boolean s;
        boolean e;

        public PQ(int start, int end, boolean s, boolean e) {
            this.start = start;
            this.end = end;
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(PQ other) {
            int left;
            if (other.s && other.e) {
                left = (other.end + other.start) / 2;
                left = Math.min(left - other.start, other.end - left);
            } else {
                left = other.end - other.start;
            }

            int right;
            if (this.s && this.e) {
                right = (this.end + this.start) / 2;
                right = Math.min(right - this.start, this.end - right);
            } else {
                right = this.end - this.start;
            }
            int diff = left - right;
            if (diff == 0) {
                return this.start - other.start;
            }

            return diff;
        }
    }

    public static void main(String[] args) {
        ExamRoom855 e = new ExamRoom855(10);
        System.out.println(e.seat());
        System.out.println(e.seat());
        e.leave(0);
        e.leave(9);
        System.out.println(e.seat());
    }
}
