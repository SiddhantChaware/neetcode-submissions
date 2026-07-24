class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Boolean> hm = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            hm.put(nums[i],true);
        }

        for(int i = 0;i < nums.length;i++){
            if(hm.containsKey(nums[i] - 1)){
                hm.put(nums[i],false);
            }
        }

        int max = 0;
        for(int key : hm.keySet()){
            if(hm.get(key)){
                max = Math.max(max,findLength(hm,key));
            }
        }
        return max;
    }

    public int findLength(Map<Integer,Boolean> hm,int key){
        int ans = 0;
        while(hm.containsKey(key)){
            ans++;
            key++;
        }
        return ans;
    }
}
