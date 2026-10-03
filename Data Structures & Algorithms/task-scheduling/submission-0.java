class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(int i = 0;i < tasks.length;i++){
            freq[tasks[i] - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> Integer.compare(b,a));
        for(int i = 0;i < 26;i++){
            if(freq[i] > 0){
                pq.offer(freq[i]);
            }
        }

        int time = 0;
        while(!pq.isEmpty()){
            List<Integer> lst = new ArrayList<>();
            for(int i = 1;i <= n+1;i++){
                if(!pq.isEmpty()){
                    int f = pq.poll();
                    f--;
                    lst.add(f); 
                }
            }

            for(int i = 0;i <lst.size();i++){
                if(lst.get(i) > 0){
                    pq.offer(lst.get(i));
                }
            }

            if(pq.isEmpty()){
                time += lst.size();
            }
            else{
                time += n+1;
            }
        }
        return time;
    }
}
