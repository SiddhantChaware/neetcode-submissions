class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if(n == 1) return 0;
        Arrays.sort(intervals,(a,b)->{
            return Integer.compare(a[0],b[0]);
        });
        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];

        int count = 0;
        
        for(int i = 1;i < n;i++){
            int curStart = intervals[i][0];
            int curEnd = intervals[i][1];

            if(prevEnd > curStart){
                prevEnd = Math.min(curEnd,prevEnd);
                count++;
            }
            else{
                prevStart = curStart;
                prevEnd = curEnd;
            }
        }
        return count;
    }
}
