import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        Comparator<Interval> comp = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end > o2.end ? 1 : o1.end < o2.end ? -1 : 0;
            }
        };
        Arrays.sort(intervals, comp);
        int result = 0;
        if (intervals.length == 0) return 0;
        Interval active = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            Interval cur = intervals[i];
            if (cur.start < active.end) {
                result++;
            } else {
                active = intervals[i];
            }
        }
        return result;
    }
}