import java.util.HashMap;
import java.util.Map;

class Solution {
    public String getHint(String secret, String guess) {
        Map<Character,Integer> map = new HashMap<>();
        int bulls = 0;
        String guessAfterBulls = "";
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                bulls++;
            } else {
                guessAfterBulls += g;
                if (map.containsKey(s)) {
                    map.put(s, map.get(s)+1);
                } else {
                    map.put(s, 1);
                }
            }
        }
        int cows = 0;
        for (char c: guessAfterBulls.toCharArray()) {
            if (map.containsKey(c) && map.get(c) > 0) {
                cows++;
                map.put(c, map.get(c) - 1);
            }
        }
        return bulls + "A" + cows + "B";
    }
}