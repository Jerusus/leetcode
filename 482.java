class Solution {
    public String licenseKeyFormatting(String S, int K) {
        S = S.replaceAll("-","").toUpperCase();
        String res = "";
        while(S.length() > K) {
            res = "-" + S.substring(S.length()-K) + res;
            S = S.substring(0, S.length()-K);
        }
        res = S + res;
        return res;
    }
}