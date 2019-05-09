import java.util.Stack;

class Solution {
    class Weather {
        int day;
        int temp;
        Weather(int day, int temp) {
            this.day = day;
            this.temp = temp;
        }
    }
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<Weather> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            Weather w = new Weather(i, T[i]);
            while (!stack.isEmpty() && stack.peek().temp < w.temp) {
                Weather old = stack.pop();
                res[old.day] = w.day - old.day;
            }
            stack.add(w);
        }
        return res;
    }
}