class Solution91 {
    public static void main(String args[]) {
        Solution91 s = new Solution91();
        s.numDecodings("12");
    }

    public int numDecodings(String s) {
        // BS edge cases.
        if (s.charAt(0) == '0')
            return 0;
        if (s.length() == 0)
            return 0;
        if (s.length() == 1) {
            int v = Integer.parseInt(s);
            return v > 0 ? 1 : 0;
        }

        // dp index represents string index - 1.
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < s.length(); i++) {
            int val = 0;
            String single = "" + s.charAt(i);
            String dbl = s.substring(i - 1, i + 1);
            int single_num = Integer.parseInt(single);
            if (single_num < 10 && single_num > 0) {
                val += dp[i];
            }
            int dbl_num = Integer.parseInt(dbl);
            if (dbl.charAt(0) != '0' && dbl_num >= 10 && dbl_num <= 26) {
                val += dp[i - 1];
            }

            dp[i + 1] = val;
        }
        return dp[s.length()];
    }
}