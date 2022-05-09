import java.util.Stack;

class Group {
  Character val;
  int count;

  Group(Character val, int count) {
    this.val = val;
    this.count = count;
  }
}

class Solution {
  public String removeDuplicates(String s, int k) {
    Stack<Group> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (!stack.isEmpty() && stack.peek().val == c) {
        if (stack.peek().count + 1 == k) {
          stack.pop();
        } else {
          stack.peek().count++;
        }
      } else {
        stack.add(new Group(c, 1));
      }
    }
    String res = "";
    while (!stack.isEmpty()) {
      Group g = stack.pop();
      for (int i = 0; i < g.count; i++) {
        res = g.val + res;
      }
    }
    return res;
  }
}