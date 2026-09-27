class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] merge = new int[n+m];
        int i = 0;
        int j = 0;
        int idx = 0;
        while(i < n && j < m){
            if(nums1[i] < nums2[j]){
                merge[idx++] = nums1[i];
                i++;
            }
            else{
                merge[idx++] = nums2[j];
                j++;
            }
        }
        while(i < n){
            merge[idx++] = nums1[i];
            i++;
        }
        while(j < m){
            merge[idx++] = nums2[j];
            j++;
        }

        if(merge.length % 2 == 0){
            return (double)(merge[merge.length/2 - 1] + merge[merge.length/2])/2;
        }
        return (double)(merge[merge.length/2]);
    }
}
