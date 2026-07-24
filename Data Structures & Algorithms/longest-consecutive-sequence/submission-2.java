class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        if(nums.length <= 1) return nums.length;
        int result = 1;
        int temp = 1;
        for(int i = 0;i < nums.length-1;i++){
            if((nums[i+1] - nums[i]) == 1){
                temp++;
                 result = Math.max(temp,result);
            }
            if((nums[i+1] - nums[i]) > 1){
                temp = 1;
            }
        }
        return result;
    }
}
