import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

class Solution {
    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        Collections.sort(intervals, new IntervalComparator());
        Interval newInterval = null;
        for (int i = 0; i < intervals.size(); i++) {
            Interval thisInterval = intervals.get(i);
            if (newInterval == null) {
                newInterval = thisInterval;
            } else if (thisInterval.start > newInterval.end) {
                result.add(newInterval);
                newInterval = thisInterval;
            } else if (thisInterval.start == newInterval.end || thisInterval.end > newInterval.end) {
                newInterval = new Interval(newInterval.start, thisInterval.end);
            }
        }
        if (newInterval != null) {
            result.add(newInterval);
        }
        return result;
    }
}