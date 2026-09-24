class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int left_max = -1;
        int right_max = -1;

        for(int i = 0;i < n;i++){
            left_max = Math.max(height[i],left_max);
            left[i] = left_max;

            right_max = Math.max(height[n-i-1],right_max);
            right[n-i-1] = right_max;
            
        }

        int res = 0;
        for(int i = 0;i < n;i++){
            int temp = Math.min(left[i],right[i]) - height[i];
            res += temp;
        }
        return res;
    }
}
