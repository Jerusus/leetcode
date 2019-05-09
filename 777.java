import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean canTransform(String start, String end) {
        if (start.length() != end.length()) return false;
        if (!start.replaceAll("X","").equals(end.replaceAll("X",""))) return false;
        List<Integer> r1 = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for (int i = 0; i < start.length(); i++) {
            char c = start.charAt(i);
            if (c == 'R') r1.add(i);
            if (c == 'L') l1.add(i);
        }
        for (int i = 0; i < end.length(); i++) {
            char c = end.charAt(i);
            if (c == 'R') r2.add(i);
            if (c == 'L') l2.add(i);
        }
        if (r1.size() != r2.size()) return false;
        if (l1.size() != l2.size()) return false;
        for (int i = 0; i < r1.size(); i++) {
            if (r1.get(i) > r2.get(i)) return false;
        }
        for (int i = 0; i < l1.size(); i++) {
            if (l1.get(i) < l2.get(i)) return false;
        }
        return true;
    }
}