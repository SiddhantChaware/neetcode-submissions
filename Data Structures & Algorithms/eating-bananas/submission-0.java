class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for(int i = 0;i < piles.length;i++){
            max = Math.max(max,piles[i]);
        }
        int res = max;
        int start = 1;
        int end = max;
        while(start <= end){
            int mid = start + (end-start)/2;
            long val = 0;
            for(int i = 0;i < piles.length;i++){
                val += ((piles[i] +mid-1)/mid);
            }
            if(val <= h){
                res = Math.min(res,mid);
                end = mid-1;
            }
            else{
                start = mid + 1;
            }
        }
        return res;
    }
}
