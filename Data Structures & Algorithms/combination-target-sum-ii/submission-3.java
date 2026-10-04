class Solution {
    public void solve(List<List<Integer>> res,List<Integer> curr,int idx,int[] nums,int target){
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(idx == nums.length || target < 0){
            return;
        }

        for(int i = idx;i < nums.length;i++){
            if(i > idx && nums[i] == nums[i-1]){
                continue;
            }
            if(nums[i] > target){
                break;
            }
            if(nums[i] <= target){
                curr.add(nums[i]);
                solve(res,curr,i+1,nums,target-nums[i]);
                curr.remove(curr.size()-1);
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        solve(res,new ArrayList<>(),0,candidates,target);
        return res;
    }
}
