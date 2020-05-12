class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] merged = new int[m + n];
        
        int i = 0, j = 0, t = 0;
        
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                merged[t++] = nums1[i++];
            } else {
                merged[t++] = nums2[j++];
            }
        }
        
        while (i < m) {
            merged[t++] = nums1[i++];
        }
        
        while (j < n) {
            merged[t++] = nums2[j++];
        }
        
        for (int a = 0; a < m + n; a++) {
            nums1[a] = merged[a];
        }
    }
}