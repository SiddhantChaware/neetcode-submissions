class Solution {
    public void solve(List<List<Integer>> res,List<Integer> curr,int idx,int[] nums){
        res.add(new ArrayList<>(curr));
        
        for(int i = idx;i < nums.length;i++){
            if(i > idx && nums[i] == nums[i-1]){
                continue;
            }
            curr.add(nums[i]);
            solve(res,curr,i+1,nums);
            curr.remove(curr.size()-1);
        }

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        solve(res,new ArrayList<>(),0,nums);
        return res;
    }
}
