class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> st = new HashSet<>();
        int left = 0;
        int res = 0;
        for(int right = 0;right < s.length();right++){
            char rch = s.charAt(right);
            while(st.contains(rch)){
                char lch = s.charAt(left);
                st.remove(lch);
                left++;
            }
            st.add(rch);
            res = Math.max(res,right-left+1);
        }
        return res;
    }
}
