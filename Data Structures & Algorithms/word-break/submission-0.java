class Solution {
    public boolean solve(String s,int idx,List<String> wordDict,Boolean[] dp){
        int n = s.length();
        if(idx == n){
            return true;
        }

        if(dp[idx] != null){
            return dp[idx];
        }
        for(int endIdx = idx + 1;endIdx <= n;endIdx++){
            String split = s.substring(idx,endIdx);
            if(wordDict.contains(split) && solve(s,endIdx,wordDict,dp)){
                return dp[idx] = true;
            }
        }
        return dp[idx] = false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        return solve(s,0,wordDict,dp);
    }
}
