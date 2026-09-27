class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int res = Integer.MAX_VALUE;
        while(start <= end){
            int mid = start + (end - start)/2;
             
            if(nums[start] <= nums[mid]){
                res = Math.min(res,nums[start]);
                start = mid + 1;
            }
            else{
                res = Math.min(res,nums[mid]);
                end = mid - 1;
            }
             
        }
        return res;
    }
}
