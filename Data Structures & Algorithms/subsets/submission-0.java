class Solution {
    public void solve(List<List<Integer>> res,List<Integer> temp,int idx,int[] nums){
        if(nums.length == idx){
            res.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[idx]);
        solve(res,temp,idx+1,nums);
        temp.remove(temp.size()-1);
        solve(res,temp,idx+1,nums);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        solve(res,new ArrayList<>(),0,nums);
        //res.add(new ArrayList<>());
        return res;    
    }
}
