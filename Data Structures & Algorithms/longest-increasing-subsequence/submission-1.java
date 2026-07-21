class Solution {
    public int solve(int prev,int idx,int[] nums,int[][] dp){
        int n = nums.length;
        if(idx >= n){
            return 0;
        }

        if(prev != -1 && dp[prev][idx] != -1){
            return dp[prev][idx];
        }
        int take = 0;
        if(prev == -1 || nums[idx] > nums[prev]){
            take = 1 + solve(idx,idx+1,nums,dp);
        }
        int skip = solve(prev,idx+1,nums,dp);

        if(prev != -1){
            dp[prev][idx] = Math.max(skip,take);
        }
        return Math.max(skip,take);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(-1,0,nums,dp);
    }
}
