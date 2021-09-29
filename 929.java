import java.util.HashSet;
import java.util.Set;

class Solution {
  public int numUniqueEmails(String[] emails) {
    Set<String> res = new HashSet<>();
    for (String e : emails) {
      String[] s = e.split("@");
      String l = s[0].split("\\+")[0].replaceAll("\\.", "");
      res.add(l + "@" + s[1]);
    }
    return res.size();
  }
}