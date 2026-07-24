class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            hm.put(nums[i],i);
        }

        int[] ans = new int[2];
        for(int i = 0;i < nums.length;i++){
            int first = nums[i];
            int find = target - nums[i];
            if(hm.containsKey(find) && hm.get(find) != i){
                ans[0] = i;
                ans[1] = hm.get(find);
                break;
            }
        }
        return ans;
    }
}
