import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    class Child implements Comparable<Child> {
        int index;
        int val;
        Child(int index, int val) {
            this.index = index;
            this.val = val;
        }
        @Override
        public int compareTo(Child o) {
            return this.val > o.val ? 1 : this.val < o.val ? -1 : 0;
        }
    }
    public int candy(int[] ratings) {
        Queue<Child> queue = new PriorityQueue<>();
        for (int i = 0; i < ratings.length; i++) {
            Child c = new Child(i, ratings[i]);
            queue.add(c);
        }
        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);
        while (!queue.isEmpty()) {
            Child c = queue.poll();
            int index = c.index;
            int cur = candy[index];
            if (index - 1 >= 0 && ratings[index-1] > c.val) {
                candy[index-1] = Math.max(candy[index-1], cur + 1);
            }
            if (index + 1 < ratings.length && ratings[index+1] > c.val) {
                candy[index+1] = Math.max(candy[index+1], cur + 1);
            }
        }
        int count = 0;
        for (int c : candy) {
            count += c;
        }
        return count;
    }
}