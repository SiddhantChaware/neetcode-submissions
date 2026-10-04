class Solution {
    public void solve(Set<List<Integer>> res,List<Integer> temp,int idx,int[] nums,int target){
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = idx;i < nums.length;i++){
            if(nums[i] <= target){
                temp.add(nums[i]);
                solve(res,temp,i,nums,target-nums[i]);
                temp.remove(temp.size()-1);
            }
          //  solve(res,temp,i,nums,target);
        }
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Set<List<Integer>> res = new HashSet<>();
        solve(res,new ArrayList<>(),0,nums,target);
        return new ArrayList<>(res);    
    }
}
