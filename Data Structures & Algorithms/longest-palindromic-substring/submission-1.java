class Solution {
    public String longestPalindrome(String s) {
        //BluePrint
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxlen = 0;
        int maxStart = 0;
        for(int l = 1;l <= n;l++){
            for(int i = 0;i+l-1 < n;i++){
                int j = i + l - 1;
                if(i == j){
                    dp[i][j] = true;
                }
                else if(i+1 == j){
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                }
                else{
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i+1][j-1];
                }
                if(dp[i][j]){
                    int curlen = j - i + 1;
                    if(maxlen < curlen){
                        maxlen = curlen;
                        maxStart = i;
                    }
                }
            }
        }
        return s.substring(maxStart,maxlen+maxStart);
    }
}
