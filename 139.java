import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<String, Boolean> myMap = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if (myMap.containsKey(s)) return myMap.get(s);
        boolean result = false;
        for (String word : wordDict) {
            if (s.equals(word)) {
                myMap.put(s, true);
                return true;
            }
            if (s.indexOf(word) == 0) {
                result = result || wordBreak(s.replaceFirst(word, ""), wordDict);
            }
        }
        myMap.put(s, result);
        return result;
    }
}