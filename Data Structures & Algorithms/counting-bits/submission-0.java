class Solution {
    public int[] countBits(int n) {
        int[] countBits = new int[n+1];
        countBits[0] = 0;
         for(int i = 1;i <= n;i++){
            int res = 0;
            int num = i;
            while(num != 0){
                res += num & 1;
                num = num >>> 1;
            }
            countBits[i] = res;
         }
         return countBits;
    }
}
