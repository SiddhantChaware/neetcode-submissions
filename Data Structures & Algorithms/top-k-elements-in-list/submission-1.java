class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> hm = new HashMap<>();
        List<Integer> lst = new ArrayList<>();
        for(int i = 0;i < nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->
        Integer.compare(b[1],a[1]));

        for(int key : hm.keySet()){
            pq.add(new int[]{key,hm.get(key)});
        }

        int[] res = new int[k];
        for(int i = 0;i < k;i++){
            int[] temp = pq.poll();
            res[i] = temp[0];
        }
        return res;
    }
}
