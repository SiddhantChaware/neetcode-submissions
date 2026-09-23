class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for(int i = 0;i < nums.length;i++){
            st.add(nums[i]);
        }
        return !(st.size() == nums.length);
    }
}