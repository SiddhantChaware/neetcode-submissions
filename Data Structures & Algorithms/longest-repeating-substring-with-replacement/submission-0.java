class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int[] charFreq = new int[26];
        int result = 0;
        int maxfreq = 0;
        for(int right = 0;right < s.length();right++){
            char rch = s.charAt(right);
            charFreq[rch - 'A']++;
            if(charFreq[rch - 'A'] > maxfreq){
                maxfreq = charFreq[rch - 'A'];
            }

            while((right - left + 1) - maxfreq > k){
                char lch = s.charAt(left);
                charFreq[lch - 'A']--;
                left++;
            }
            result = Math.max(right - left + 1,result);
        }
        return result;
    }
}
