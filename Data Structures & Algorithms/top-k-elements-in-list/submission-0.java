class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(b[1],a[1]));

        for(int key : map.keySet()){
            pq.add(new int[]{key,map.get(key)});
        }

        int[] result = new int[k];
        for(int i = 0;i < k;i++){
            int[] temp = pq.poll();
            result[i] = temp[0];
        }
        return result;
    }
}
