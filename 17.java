import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    Map<Character, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new ArrayList<String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res = new ArrayList<>();
        permute(res, digits, "");
        return res;
    }

    public void permute(List<String> res, String digits, String current) {
        if (digits.length() == 0) {
            res.add(current);
            return;
        }
        for (int i = 0; i < map.get(digits.charAt(0)).length(); i++) {
            permute(res, digits.substring(1), current + map.get(digits.charAt(0)).charAt(i));
        }
    }
}