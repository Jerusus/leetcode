import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    // public static void main(String[] args) {
    //     Solution621 s = new Solution621();
    //     System.out.println(s.leastInterval(new char[]{'a','b','c','a','a'}, 2));
    // }

    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        int result = 0;
        Map<Character, Task> taskMap = new HashMap<>();
        for (char c : tasks) {
            if (!taskMap.containsKey(c)) {
                taskMap.put(c, new Task(c, 1));
            } else {
                taskMap.get(c).count++;
            }
        }
        Comparator comp = new Comparator<Task>() {
            @Override
            public int compare(Task a, Task b) {
                return a.count > b.count ? -1 : a.count < b.count ? 1 : 0;
            }
        };
        PriorityQueue<Task> q = new PriorityQueue<>(taskMap.keySet().size(), comp);
        q.addAll(taskMap.values());
        while(!q.isEmpty()) {
            // outer loop removes tries to remove 1 element each time
            // inner loop tries each element starting with the highest priority
            List<Task> temp = new ArrayList<>();
            while(!q.isEmpty()) {
                Task task = q.poll();
                if (isPlaceable(task, result, n)) {
                    task.count--;
                    task.lastPlaced = result;
                    if (task.count > 0) temp.add(task);
                    break;
                } else {
                    temp.add(task);
                }
            }
            q.addAll(temp);
            result++;
        }
        return result;
    }

    public boolean isPlaceable(Task task, int place, int interval) {
        return place >= (task.lastPlaced + interval + 1);
    }

    class Task {
        char c;
        int lastPlaced;
        int count;
        Task(char c, int count) {
            this.c = c;
            this.lastPlaced = Integer.MIN_VALUE;
            this.count = count;
        }

        @Override
        public String toString() {
            return "char: " + this.c +
            ", lastPlaced: " + this.lastPlaced +
            ", count: " + this.count;
        }
    }
}
