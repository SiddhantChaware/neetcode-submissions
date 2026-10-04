class Solution {
    public void solve(String digit,List<String> res,StringBuilder sb,String[] map,int idx){
        if(idx == digit.length()){
            res.add(sb.toString());
            return;
        }
        int n = digit.charAt(idx)-'0';
        String letter = map[n];

        for(int i = 0;i < letter.length();i++){
            sb.append(letter.charAt(i));
            solve(digit,res,sb,map,idx+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public List<String> letterCombinations(String digits) {
        
        String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res = new ArrayList<>();
        if(digits.length() == 0) return res;
        solve(digits,res,new StringBuilder(),map,0);
        return res;
    }
}
