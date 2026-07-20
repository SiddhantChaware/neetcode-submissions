class Solution {
    public int solve(int idx,int end,int[] nums,int[] dp){
        if(idx >= end){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }

        int takefirst = nums[idx] + solve(idx+2,end,nums,dp);
        int skipfirst = solve(idx+1,end,nums,dp);

        return dp[idx] = Math.max(takefirst,skipfirst);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] dp1 = new int[nums.length];
        Arrays.fill(dp1,-1);
        int tookFirst = solve(0,n-1,nums,dp1);

        int[] dp2 = new int[nums.length];
        Arrays.fill(dp2,-1);
        int tookLast = solve(1,n,nums,dp2);

        return Math.max(tookFirst,tookLast);
    }
}
