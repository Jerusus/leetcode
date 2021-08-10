class Solution {
  public String addStrings(String num1, String num2) {
    String res = "";
    int ind = 1;
    int carry = 0;
    while (true) {
      boolean a_range = ind <= num1.length() ? true : false;
      boolean b_range = ind <= num2.length() ? true : false;
      if (!a_range && !b_range) {
        if (carry > 0) {
          res = carry + res;
        }
        return res;
      }
      int a = a_range ? num1.charAt(num1.length() - ind) - 48 : 0;
      int b = b_range ? num2.charAt(num2.length() - ind) - 48 : 0;
      int sum = a + b + carry;
      res = (sum % 10) + res;
      carry = sum / 10;
      ind++;
    }
  }
}