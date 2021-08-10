import java.util.PriorityQueue;

class Solution915 {
  public static void main(String args[]) {
    Solution915 s = new Solution915();
    s.partitionDisjoint(new int[] { 1, 1 });
  }

  public int partitionDisjoint(int[] nums) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = nums.length - 1; i >= 0; i--) {
      pq.add(nums[i]);
    }
    int max = 0;
    int count = 0;
    while (!pq.isEmpty()) {
      int curr = nums[count];
      pq.remove(curr);
      max = Math.max(max, curr);
      count++;
      if (max <= pq.peek()) {
        return count;
      }
    }
    return 0;
  }
}