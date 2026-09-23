class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < s.length();i++){
            char ch = s.charAt(i);
            int val = (int)ch;
            if((val >= 65 && val <= 90) || (val >= 48 && val <= 57) || 
            (val >= 97 && val <= 122)){
                sb.append(ch);
            }
        }

        int start = 0;
        int end = sb.length()-1;
        while(start < end){
            if(sb.charAt(start) != sb.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
