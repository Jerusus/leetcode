import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> roomZero = rooms.get(0);
        set.add(0);
        queue.addAll(roomZero);
        while(!queue.isEmpty()) {
            int currentRoom = queue.poll();
            set.add(currentRoom);
            List<Integer> keys = rooms.get(currentRoom);
            for (int i = 0; i < keys.size(); i++) {
                if (!set.contains(keys.get(i))) {
                    queue.add(keys.get(i));
                }
            }
        }
        return set.size() == rooms.size();
    }
}

