import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        Comparator<Interval> intComp = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start > o2.start ? 1 : o1.start < o2.start ? -1 : 0;
            }
        };
        intervals.add(newInterval);
        intervals.sort(intComp);
        Interval cur = intervals.get(0);
        for (int i = 1; i < intervals.size();) {
            Interval at = intervals.get(i);
            // if overlap
            if (at.start <= cur.end) {
                cur.end = Math.max(at.end, cur.end);
                cur.start = Math.min(at.start, cur.start);
                intervals.remove(i);
            } else {
                cur = at;
                i++;
            }
        }
        return intervals;
    }
}