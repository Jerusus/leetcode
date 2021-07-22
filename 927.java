import java.util.Arrays;

class Solution927 {
  public static void main(String args[]) {
    Solution927 s = new Solution927();
    int[] arr = new int[] { 1, 0, 1, 0, 1 };
    s.threeEqualParts(arr);
  }

  public int[] threeEqualParts(int[] arr) {
    String s = Arrays.toString(arr).replaceAll("\\[|\\]|,|\\s", "");
    if (!s.contains("1"))
      return new int[] { 0, 2 };
    String aa = s.substring(0, 1);
    String bb = s.substring(1, s.length() - 1);
    String cc = s.substring(s.length() - 1);
    String a = trm(aa);
    String b = trm(bb);
    String c = trm(cc);
    while (comp(b, a) >= 0 && comp(b, c) >= 0) {
      if (comp(a, b) == 0 && comp(b, c) == 0) {
        return new int[] { aa.length() - 1, aa.length() + bb.length() };
      }
      if (comp(c, a) <= 0) {
        cc = bb.charAt(bb.length() - 1) + cc;
        bb = bb.substring(0, bb.length() - 1);
      } else {
        aa = aa + bb.charAt(0);
        bb = bb.substring(1);
      }
      a = trm(aa);
      b = trm(bb);
      c = trm(cc);
    }

    return new int[] { -1, -1 };
  }

  String trm(String s) {
    if (s.indexOf("1") >= 0) {
      return s.substring(s.indexOf("1"));
    } else {
      return "0";
    }
  }

  int comp(String s, String o) {
    if (s.length() > o.length()) {
      return 1;
    } else if (o.length() > s.length()) {
      return -1;
    }

    return s.compareTo(o);
  }
}