class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int i = 0;
        int j = n - 1;
        int result  = 0;

        while(i < j){
            int b = Math.min(heights[i],heights[j]);
            int l = j - i;

            int area = l * b;
            result = Math.max(area,result);
            if(heights[i] < heights[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return result;
    }
}
