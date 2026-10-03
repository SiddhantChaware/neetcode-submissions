class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for(int num : nums){
            pq.offer(num);
           
        }
        int res = 0;
        for(int i = 1;i < k;i++){
            pq.poll();
        }
        return pq.peek();
    }
}
