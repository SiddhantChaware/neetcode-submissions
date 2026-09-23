class Solution {
    public int findLen(Map<Integer,Boolean> map,int k){
        int ans = 0;
        while(map.containsKey(k)){
            k++;
            ans++;
        }
        return ans;
    }
    public int longestConsecutive(int[] nums) {
        Map<Integer,Boolean> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            map.put(nums[i],true);
        }

        int res = 0;
        for(int i = 0;i < nums.length;i++){
            if(map.containsKey(nums[i]-1)){
                map.put(nums[i],false);
            }
        }
        
        for(int key : map.keySet()){
            if(map.get(key)){
                res = Math.max(res,findLen(map,key));
            }
        }
        return res;

    }
}
