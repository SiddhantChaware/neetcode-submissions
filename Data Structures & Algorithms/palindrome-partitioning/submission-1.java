class Solution {
    public void solve(List<List<String>> res,List<String> curr,String s,boolean[][] dp,int idx){
        if(idx == s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i = idx;i < s.length();i++){
            if(dp[idx][i]){
                curr.add(s.substring(idx,i+1));
                solve(res,curr,s,dp,i+1);
                curr.remove(curr.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int l = 1;l <= n;l++){
            for(int i = 0;i+l-1 < n;i++){
                int j = i+l-1;
                if(i == j){
                    dp[i][j] = true;
                }
                else if(i+1 == j){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }
                else{
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && (dp[i+1][j-1]);
                }
            }
        }
        solve(res,new ArrayList<>(),s,dp,0);
        return res;
    }
}
