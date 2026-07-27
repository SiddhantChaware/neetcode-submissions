class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int maxProfit = 0;
        int n = prices.length;
        for(int right = 0;right < n;right++){
            if(prices[right] > prices[left]){
                maxProfit = Math.max(maxProfit,prices[right]-prices[left]);
            }
            else{
                left = right;
            }
        }
        return maxProfit;
    }
}
