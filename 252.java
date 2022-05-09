import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Meeting {
  int start;
  int end;

  Meeting(int start, int end) {
    this.start = start;
    this.end = end;
  }
}

class Solution {
  public boolean canAttendMeetings(int[][] intervals) {
    List<Meeting> list = new ArrayList<>();
    for (int[] interval : intervals) {
      list.add(new Meeting(interval[0], interval[1]));
    }
    Collections.sort(list, new Comparator<Meeting>() {
      @Override
      public int compare(Meeting o1, Meeting o2) {
        return Integer.compare(o1.start, o2.start);
      }
    });
    for (int i = 0; i < list.size() - 1; i++) {
      Meeting a = list.get(i);
      Meeting b = list.get(i + 1);
      if (a.end > b.start) {
        return false;
      }
    }
    return true;
  }
}