class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < str.length;i++){
            sb.append(str[i]);
        }
        int i = 0;
        int j = sb.length()-1;
        while(i < j){
            if(!Character.isLetterOrDigit(sb.charAt(i))){
                i++;
                continue;
            }
            if(!Character.isLetterOrDigit(sb.charAt(j))){
                j--;
                continue;
            }
            if(i < j){
                if(sb.charAt(i) != sb.charAt(j)){
                return false;
                }
                i++;
                j--;
            }   
        }
        return true;
    }
}
