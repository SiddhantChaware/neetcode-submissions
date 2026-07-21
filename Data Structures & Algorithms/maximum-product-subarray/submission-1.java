class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int pre = 1;
        int suff = 1;
        int result = 0;
        for(int i = 0;i < n;i++){
            if(pre == 0) pre = 1;
            if(suff == 0) suff = 1;

            pre = pre * nums[i];
            suff = suff * nums[n-1-i];

            result = Math.max(result,Math.max(pre,suff));
        }
        return result;
    }
}
