class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] scount = new int[26];
        int[] tcount = new int[26];
        for(int i = 0;i < s.length();i++){
            char ch = s.charAt(i);
            scount[ch - 'a']++;
        }

        for(int i = 0;i < t.length();i++){
            char ch = t.charAt(i);
            tcount[ch - 'a']++;
        }

        for(int i = 0;i < s.length();i++){
            char ch = s.charAt(i);
            if(scount[ch - 'a'] != tcount[ch - 'a']){
                return false;
            }
        }
        return true;
    }
}
