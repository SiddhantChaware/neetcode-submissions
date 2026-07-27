class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int result = 0;
        Set<Character> st = new HashSet<>();
        for(int right = 0;right < s.length();right++){
            char ch = s.charAt(right);
            while(st.contains(ch)){
                st.remove(s.charAt(left));
                left++;
            }
            st.add(ch);
            result = Math.max(result,right-left+1);
        }
        return result;
    }
}
