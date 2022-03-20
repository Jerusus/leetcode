package wc279;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution2 {
  public static void main(String args[]) {
    Solution2 s = new Solution2();
    long l = s.smallestNumber(-7650);
    System.out.println(s);
  }

  public long smallestNumber(long num) {
    if (num == 0) {
      return 0;
    }
    if (num < 0) {
      char[] ca = String.valueOf(num * -1).toCharArray();
      Arrays.sort(ca);
      char[] temp = new char[ca.length];
      for (int i = 0; i < temp.length; i++) {
        temp[i] = ca[ca.length - i - 1];
      }
      return Long.parseLong(new String(temp)) * -1;
    } else {
      String s = String.valueOf(num);
      int zerocount = 0;
      String temp = "";
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '0') {
          zerocount++;
        } else {
          temp += s.charAt(i);
        }
      }
      char[] ca = temp.toCharArray();
      Arrays.sort(ca);
      s = new String(ca);
      String result = s.charAt(0) + "";
      for (int i = 0; i < zerocount; i++) {
        result += "0";
      }
      result += s.substring(1);
      return Long.parseLong(result);
    }
  }
}