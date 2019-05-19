import java.util.List;

class Solution {
  public int totalFruit(int[] tree) {
    int slow = 0;
    int fast = 0;
    int max = 0;
    List<Integer> types = new ArrayList<>();
    while (fast < tree.length) {
      if (!types.contains(tree[fast])) {
        types.add(tree[fast]);
        // check if too many types
        if (types.size() == 3) {
          slow = fast - 1;
          int savedType = tree[slow];
          while (tree[slow] == savedType) {
            slow--;
          }
          types.remove(Integer.valueOf(tree[slow]));
          slow++;
          continue;
        }
      }
      int length = fast - slow + 1;
      max = Math.max(max, length);
      fast++;
    }
    return max;
  }
}