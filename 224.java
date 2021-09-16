import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
  public int calculate(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    stack.add('{');
    for (char c : s.toCharArray()) {
      if (c == ' ')
        continue;
      stack.add(c);
    }
    stack.add(')');
    return ev(stack);
  }

  int ev(Deque<Character> stack) {
    int cur = 0;
    while (!stack.isEmpty()) {
      switch (stack.removeFirst()) {
        case ')':
          return;
      }
    }
  }
}