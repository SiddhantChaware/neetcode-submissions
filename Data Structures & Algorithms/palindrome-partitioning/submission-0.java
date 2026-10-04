class Solution {
    public boolean isPalindrome(String str){
        int i = 0;
        int j = str.length()-1;
        while(i < j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public void solve(List<List<String>> res,List<String> curr,String s,int idx){
        if(idx == s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i = idx;i < s.length();i++){
            String check = s.substring(idx,i+1);
            if(isPalindrome(check)){
                curr.add(check);
                solve(res,curr,s,i+1);
                curr.remove(curr.size()-1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        solve(res,new ArrayList<>(),s,0);
        return res;
    }
}
