class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (k <= nums.length)
            return quickSelect(nums, 0, nums.length - 1, k);
        return -1;
    }
    
    private int quickSelect(int[] nums, int left, int right, int k) {
        if (left <= right) {
            int index = partition(nums, left, right);
            if (index == k - 1) {
                return nums[index];
            }
            if (index < k - 1)
                return quickSelect(nums, index + 1, right, k);
            return quickSelect(nums, left, index - 1, k);
        }
        return - 1;
    }
    
    private int partition(int[] nums, int left, int right) {
        int index = left - 1;
        for (int i = left; i < right; i++) {
            if (nums[i] >= nums[right]) {
                swap(nums, ++index, i);
            }
        }
        index += 1;
        swap(nums, index, right);
        return index;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}