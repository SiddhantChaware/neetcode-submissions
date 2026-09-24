class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int res = 0;
        for(int right = 1;right < prices.length;right++){
            if(prices[right] > prices[left]){
                res = Math.max(res,prices[right] - prices[left]);
            }
            else{
                left = right;
            }
        }
        return res;
    }
}
