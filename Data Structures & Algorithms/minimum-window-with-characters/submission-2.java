class Solution {
    public String minWindow(String s, String t) {
        int[] tfreq = new int[128];
        int matchtotal = 0;
        for(int i = 0;i < t.length();i++){
            char ch = t.charAt(i);
            if(tfreq[ch] == 0){
                matchtotal++;
            }
            tfreq[ch]++;
        }

        int[] sfreq = new int[128];
        int match = 0;
        int left = 0;
        int minlen = Integer.MAX_VALUE;
        int startIdx = 0;

        for(int right = 0;right < s.length();right++){
            char rch = s.charAt(right);
            sfreq[rch]++;
            if(sfreq[rch] == tfreq[rch]){
                match++;
            }

            while(matchtotal == match){
                char lch = s.charAt(left);
                if(sfreq[lch] == tfreq[lch]){
                    match--;
                }
                if((right-left+1) < minlen){
                    minlen = Math.min(right-left+1 , minlen);
                    startIdx = left;
                }
                sfreq[lch]--;
                left++;
            }
        }
        return minlen == Integer.MAX_VALUE ? "" : s.substring(startIdx,startIdx+minlen);
    }
}
