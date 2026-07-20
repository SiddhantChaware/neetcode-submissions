class Solution {
    public int solve(int i,String s,int[] dp){
        int n = s.length();
        if(i >= n){
            return 1;
        }
        if(s.charAt(i) == '0'){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }

        int takeI = solve(i+1,s,dp);
        int takeIplus = 0;
        if(i+1 < n){
            if(s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <= '6')){
                takeIplus = solve(i+2,s,dp);
            }
        }
        return dp[i] = takeI + takeIplus;
    }
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(0,s,dp);
    }
}
