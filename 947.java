import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    class Stone {
        int x;
        int y;
        boolean visited;
        Stone(int x, int y) {
            this.x = x;
            this.y = y;
            this.visited = false;
        }
    }
    public int removeStones(int[][] stones) {
        List<Stone> list = new ArrayList<>();
        Map<Integer,List<Stone>> xmap = new HashMap<>();
        Map<Integer,List<Stone>> ymap = new HashMap<>();
        for (int[] stone : stones) {
            int x = stone[0];
            int y = stone[1];
            Stone s = new Stone(x,y);
            list.add(s);
            if (xmap.containsKey(x)) {
                xmap.get(x).add(s);
            } else {
                List<Stone> maplist = new ArrayList<>();
                maplist.add(s);
                xmap.put(x,maplist);
            }
            if (ymap.containsKey(y)) {
                ymap.get(y).add(s);
            } else {
                List<Stone> maplist = new ArrayList<>();
                maplist.add(s);
                ymap.put(y,maplist);
            }
        }
        int max = 0;
        for (Stone s : list) {
            int count = spread(s,xmap,ymap);
            if (count > 0) max += count - 1;
        }
        return max;
    }

    private int spread(Stone cur, Map<Integer,List<Stone>> xmap, Map<Integer,List<Stone>> ymap) {
        if (cur.visited) return 0;
        cur.visited = true;
        int count = 1;
        int x = cur.x;
        int y = cur.y;
        for (Stone s : xmap.get(x)) {
            count += spread(s,xmap,ymap);
        }
        for (Stone s : ymap.get(y)) {
            count += spread(s,xmap,ymap);
        }
        return count;
    }
}