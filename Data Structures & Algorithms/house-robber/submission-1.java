class Solution {
    public int solve(int idx,int[] nums,int[] dp){
        int  n = nums.length;
        if(idx >= n){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        int takefirst = nums[idx] + solve(idx+2,nums,dp);
        int skipfirst = solve(idx+1,nums,dp);

        return dp[idx] = Math.max(takefirst,skipfirst);
       
    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return solve(0,nums,dp);
    }
}
