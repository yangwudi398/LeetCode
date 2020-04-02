class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] combined = new int[nums1.length + nums2.length];
        int curr1 = 0, curr2 = 0, curr = 0;
        
        while (curr1 < nums1.length || curr2 < nums2.length) {
            if (curr1 < nums1.length && curr2 < nums2.length) {
                if (nums1[curr1] <= nums2[curr2]) {
                    combined[curr++] = nums1[curr1++];
                } else {
                    combined[curr++] = nums2[curr2++];
                }
            } else if (curr1 < nums1.length) {
                combined[curr++] = nums1[curr1++];
            } else {
                combined[curr++] = nums2[curr2++];
            }
        }
        
        double median;
        if (combined.length % 2 == 1) {
            median = combined[combined.length / 2];
        } else {
            median = (combined[combined.length / 2 - 1] + combined[combined.length / 2]) / 2.0;
        }
        return median;
    }
}