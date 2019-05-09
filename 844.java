import java.util.Stack;

class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stacks = new Stack<>();
        Stack<Character> stackt = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == '#' && !stacks.empty()) {
                stacks.pop();
            } else if (c != '#') {
                stacks.push(c);
            }
        }
        for (char c : T.toCharArray()) {
            if (c == '#' && !stackt.empty()) {
                stackt.pop();
            } else if (c != '#') {
                stackt.push(c);
            }
        }
        String ss = "";
        while (!stacks.isEmpty()) {
            ss = stacks.pop() + ss;
        }
        String tt = "";
        while (!stackt.isEmpty()) {
            tt = stackt.pop() + tt;
        }
        return ss.equals(tt);
    }
}