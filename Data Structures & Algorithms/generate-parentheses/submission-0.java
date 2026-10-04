class Solution {
    public void solve(int open,int close,StringBuilder sb,List<String> res,int n){
        if(open == n && close == n){
            res.add(sb.toString());
            return;
        }
        if(open < n){
            sb.append("(");
            solve(open+1,close,sb,res,n);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close < open){
            sb.append(")");
            solve(open,close+1,sb,res,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        solve(0,0,new StringBuilder(""),res,n);
        return res;    
    }
}
