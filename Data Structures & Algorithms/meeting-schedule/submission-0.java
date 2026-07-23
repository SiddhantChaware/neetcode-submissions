/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        int n = intervals.size();
        if(n <= 1) return true;
        Collections.sort(intervals,(a,b) -> Integer.compare(a.start,b.start));
        
        int prevEnd = intervals.get(0).end;
        for(int i = 1;i < n;i++){
            int curStart = intervals.get(i).start;
            int curEnd = intervals.get(i).end;

            if(prevEnd > curStart){
                return false;
            }
            else{
                prevEnd = curEnd;
            }
        }
        return true;
    }
}
