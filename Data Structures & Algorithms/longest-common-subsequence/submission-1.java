class Solution {
    public int solve(int i,int j,String text1,String text2,int[][] dp){
        int l1 = text1.length();
        int l2 = text2.length();
        if(i >= l1 || j >= l2){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int take = 0;
        if(text1.charAt(i) == text2.charAt(j)){
            take = 1 + solve(i+1,j+1,text1,text2,dp);
        }
        int skip1 = solve(i+1,j,text1,text2,dp);
        int skip2 = solve(i,j+1,text1,text2,dp);

        return dp[i][j] = Math.max(take,Math.max(skip1,skip2));
    }
    public int longestCommonSubsequence(String text1, String text2) {

        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(0,0,text1,text2,dp);
    }
}
