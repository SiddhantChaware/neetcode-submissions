class Solution {
    public int solve(int i,int amount,int[] coins,int[][] dp){

        if(amount == 0){
            return 0;
        }
        if(i >= coins.length ) return Integer.MAX_VALUE;
        if(dp[i][amount] != -1){
            return dp[i][amount];
        }

        int take = Integer.MAX_VALUE;
        if(coins[i] <= amount){
            int subResult = solve(i,amount - coins[i],coins,dp);
            if(subResult != Integer.MAX_VALUE){
                take = 1 + subResult;
            }
              
        }
        
        int skip = solve(i+1,amount,coins,dp);

        return Math.min(take,skip);
    }
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        int result = solve(0,amount,coins,dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
