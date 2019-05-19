class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        int[] dp = new int[s.length()];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < s.length(); i++) {
            int num = Integer.parseInt(s.substring(i-2, i));
            boolean dub = num >= 10 && num <= 26;
            boolean single = num < 10 && num >= 1;
            int count = 0;
            if (dub) {
                count += dp[i-2] + 1;
            }
            if (single) {
                count += dp[i-1];
            }
            dp[i] = count;
        }
        return dp[s.length()-1];
    }
}