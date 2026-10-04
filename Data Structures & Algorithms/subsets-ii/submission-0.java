class Solution {
    public void solve(Set<List<Integer>> res,List<Integer> curr,int idx,int[] nums){
        if(idx == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[idx]);
        solve(res,curr,idx+1,nums);
        curr.remove(curr.size()-1);
        solve(res,curr,idx+1,nums);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        solve(res,new ArrayList<>(),0,nums);
        return new ArrayList<>(res);
    }
}
