class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for(int s : stones){
            pq.offer(s);
        }   

        while(pq.size() > 1){
            int n1 = pq.poll();
            int n2 = pq.poll();
            if(n1 == n2){
                continue;
            }
            else if(n1 < n2){
                int num = n2 - n1;
                pq.offer(num);
            }
            else{
                int num = n1 - n2;
                pq.offer(num);
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}
