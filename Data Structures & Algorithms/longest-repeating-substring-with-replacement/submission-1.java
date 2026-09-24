class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int[] freq = new int[26];
        int result = 0;
        int maxfreq = 0;
        for(int right = 0;right < s.length();right++){
            char rch = s.charAt(right);
            freq[rch - 'A']++;
            if(freq[rch - 'A'] > maxfreq){
                maxfreq = freq[rch - 'A'];
            }

            while((right - left + 1) - maxfreq > k){
                char lch = s.charAt(left);
                freq[lch - 'A']--;
                left++;
            }
            result = Math.max(result,right-left+1);
        }
        return result;
    }
}
