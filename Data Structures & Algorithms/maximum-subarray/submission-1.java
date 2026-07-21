class Solution {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int n = nums.length;
        if(n == 1) return nums[0];
        for(int i = 0;i < n;i++){
            int sum = 0;
            for(int j = i;j < n;j++){
                sum += nums[j];
                result = Math.max(result,sum);
            }
        }
        return result;
    }
}
