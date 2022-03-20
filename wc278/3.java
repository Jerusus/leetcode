package wc278;

import java.math.BigInteger;

class Solution3 {

  public static void main(String args[]) {
    Solution3 s = new Solution3();
    String str = "";
    String ans = s.subStrHash(str, 71717, 94536, 1149, 39999);
    System.out.println(ans);
  }

  public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
    int[] pows = pows(k, power, modulo);
    for (int i = 0; i < s.length() - k + 1; i++) {
      if (hash(s.substring(i, i + k), power, modulo, pows) == hashValue) {
        return s.substring(i, i + k);
      }
    }
    return "";
  }

  int[] pows(int k, int p, int m) {
    int[] res = new int[k];
    BigInteger mod = new BigInteger("" + m);
    BigInteger base = new BigInteger("" + p);
    for (int i = 0; i < res.length; i++) {
      BigInteger exp = new BigInteger("" + i);
      BigInteger mult = base.modPow(exp, mod);
      res[i] = mult.intValue();
    }
    return res;
  }

  int hash(String s, int p, int m, int[] pows) {
    int res = 0;
    for (int i = 0; i < s.length(); i++) {
      int v = s.charAt(i) - 'a' + 1;
      res += v * pows[i];
      res %= m;
    }
    return res;
  }
}