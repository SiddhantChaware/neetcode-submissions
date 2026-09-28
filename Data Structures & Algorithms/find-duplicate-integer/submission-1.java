class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        int res = 0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);

        int tmp1 = 0;
        int tmp2 = slow;
        while(tmp1 != tmp2){
            tmp1 = nums[tmp1];
            tmp2 = nums[tmp2];
        }
        return tmp1;
    }
}
