class Solution {
    int maxLen = 0;
    int maxStart = 0;
    public void expand(int left,int right,String s){
        int n = s.length();
        while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
            
        }
        int curlen = right - left - 1;
        if(curlen > maxLen){
            maxLen = curlen;
            maxStart = left+1;
        }
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        for(int i = 0;i < n;i++){
            expand(i,i,s);
            expand(i,i+1,s);
        }    

        return s.substring(maxStart,maxStart+maxLen);
    }
}
