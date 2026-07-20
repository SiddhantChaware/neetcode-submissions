class Solution {
    public int solve(int i,int amount,int[] coins){

        if(amount == 0){
            return 0;
        }
        if(i >= coins.length ) return Integer.MAX_VALUE;
        
        int take = Integer.MAX_VALUE;
        if(coins[i] <= amount){
            int subResult = solve(i,amount - coins[i],coins);
            if(subResult != Integer.MAX_VALUE){
                take = 1 + subResult;
            }
              
        }
        
        int skip = solve(i+1,amount,coins);

        return Math.min(take,skip);
    }
    public int coinChange(int[] coins, int amount) {
        int result = solve(0,amount,coins);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
