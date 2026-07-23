class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0] != b[0]){
                return Integer.compare(a[0],b[0]);
            }
            return Integer.compare(a[1],b[1]);
        });
        int n = intervals.length;
        if(n == 1) return intervals;
        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];

        List<int[]> result = new ArrayList<>();

        for(int i = 1;i < n;i++){
            int curStart = intervals[i][0];
            int curEnd = intervals[i][1];
            if(prevEnd >= curStart){
                prevEnd = Math.max(curEnd,prevEnd);
            }
            else{
                result.add(new int[]{prevStart,prevEnd});
                prevStart = curStart;
                prevEnd = curEnd;
            }
        }
        result.add(new int[]{prevStart,prevEnd});
        return result.toArray(new int[result.size()][]);
    }
}
