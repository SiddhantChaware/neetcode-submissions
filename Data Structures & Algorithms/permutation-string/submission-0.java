class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq1 = new int[26];
        for(int i = 0;i < s1.length();i++){
            char ch = s1.charAt(i);
            freq1[ch - 'a']++;
        }

        int left = 0;
        int[] freq2 = new int[26];
        for(int right = 0;right < s2.length();right++){
            char rch = s2.charAt(right);
            freq2[rch - 'a']++;
            while((right-left+1) > s1.length()){
                char lch = s2.charAt(left);
                freq2[lch - 'a']--;
                left++;
            }
            if((right-left+1) == s1.length()){
                if(Arrays.equals(freq1,freq2)){
                    return true;
                }
            }
        }
        return false;
    }
}
