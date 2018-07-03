package interviewBit;

import java.util.ArrayList;

/**
 * Created by adarsh.sharma on 03/07/18.
 */
public class MergeIntervals {
    static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "(" + start + ", " + end + ")";
        }
    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<>();
        boolean found = false;
        boolean afterLast = false;
        int newStart = Integer.MAX_VALUE;
        int newEnd = Integer.MIN_VALUE;
        if (intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (i == 0 && newInterval.end < interval.start) {
                result.add(newInterval);
                result.addAll(intervals);
                return result;
            }
            if (nonOverlapping(interval, newInterval)) {
                if (afterLast && newInterval.end < interval.start) {
                    result.add(newInterval);
                    afterLast = false;
                }
                if (interval.end < newInterval.start) {
                    afterLast = true;
                }

                if (found) {
                    result.add(new Interval(newStart, newEnd));
                    found = false;
                }
                result.add(interval);
            } else {
                afterLast = false;
                newStart = Math.min(newStart, Math.min(interval.start, newInterval.start));
                newEnd = Math.max(newEnd, Math.max(interval.end, newInterval.end));
                found = true;
            }
            if (i == intervals.size() - 1 && newInterval.start > interval.end) {
                result.add(newInterval);
            }
        }
        if (found) {
            result.add(new Interval(newStart, newEnd));
        }

        return result;
    }

    private boolean nonOverlapping(Interval first, Interval second) {
        return first.end < second.start || first.start > second.end;
    }

    public static void main(String[] args) {
        ArrayList<Interval> input = new ArrayList<>();
        input.add(new Interval(6037774, 6198243));
        input.add(new Interval(6726550, 7004541));
        input.add(new Interval(8842554, 10866536));
        input.add(new Interval(11027721, 11341296));
        input.add(new Interval(11972532, 14746848));
        input.add(new Interval(16374805, 16706396));
        input.add(new Interval(17557262, 20518214));
        input.add(new Interval(22139780, 22379559));
        input.add(new Interval(27212352, 28404611));
        input.add(new Interval(28921768, 29621583));
        input.add(new Interval(29823256, 32060921));
        input.add(new Interval(33950165, 36418956));
        input.add(new Interval(37225039, 37785557));
        input.add(new Interval(40087908, 41184444));
        input.add(new Interval(41922814, 45297414));
        input.add(new Interval(48142402, 48244133));
        input.add(new Interval(48622983, 50443163));
        input.add(new Interval(50898369, 55612831));
        input.add(new Interval(57030757, 58120901));
        input.add(new Interval(59772759, 59943999));
        input.add(new Interval(61141939, 64859907));
        input.add(new Interval(65277782, 65296274));
        input.add(new Interval(67497842, 68386607));
        input.add(new Interval(70414085, 73339545));
        input.add(new Interval(73896106, 75605861));
        input.add(new Interval(79672668, 84539434));
        input.add(new Interval(84821550, 86558001));
        input.add(new Interval(91116470, 92198054));
        input.add(new Interval(96147808, 98979097));

        ArrayList<Interval> insert = new MergeIntervals().insert(input, new Interval(36210193, 61984219));
        System.out.println(insert);
    }
}
