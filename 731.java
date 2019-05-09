import java.util.ArrayList;
import java.util.List;

class MyCalendarTwo {

    List<Integer> starts;
    List<Integer> ends;
    public MyCalendarTwo() {
        starts = new ArrayList<>();
        ends = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        starts.add(start);
        ends.add(end);
        Collections.sort(starts);
        Collections.sort(ends);
        int active = 0;
        int s = 0;
        int e = 0;
        while (e < ends.size()) {
            if (s < starts.size() && starts.get(s) < ends.get(e)) {
                s++;
                active++;
            } else {
                e++;
                active--;
            }
            if (active > 2) {
                starts.remove(Integer.valueOf(start));
                ends.remove(Integer.valueOf(end));
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */