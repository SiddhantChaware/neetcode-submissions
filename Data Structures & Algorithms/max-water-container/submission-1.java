class Solution {
    public int maxArea(int[] heights) {
        int res = 0;
        int left = 0;
        int right = heights.length-1;
        while(left < right){
            int l = right - left;
            int b = Math.min(heights[left],heights[right]);
            res = Math.max(res, l*b);
            if(heights[left] < heights[right]){
                left++;
            } 
            else{
                right--;
            }
        }
        return res;
    }
}
