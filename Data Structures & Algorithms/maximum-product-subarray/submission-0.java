class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        for(int i = 0;i < nums.length;i++){
            int curr = 1;
            for(int j = i;j < nums.length;j++){
                curr *= nums[j];
                res = Math.max(res,curr);
            }
        }
        return res;
    }
}
