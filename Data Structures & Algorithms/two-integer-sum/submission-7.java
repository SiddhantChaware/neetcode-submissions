class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hm = new HashMap<>();
        int[] ans = new int[2];
        for(int i = 0;i < nums.length;i++){
            hm.put(nums[i],i);
        }
        for(int i = 0;i < nums.length;i++){
            int num1 = nums[i];
            int find = target - num1;
            if(hm.containsKey(find) && hm.get(find) != i){
                ans[0] = i;
                ans[1] = hm.get(find);
                break;
            }
        }
        return ans;
    }
}
