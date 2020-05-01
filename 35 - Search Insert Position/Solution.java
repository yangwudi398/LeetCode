class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0)
            return 0;
        return binarySearch(nums, 0, nums.length - 1, target);
        
    }
    
    public int binarySearch(int[] nums, int start, int end, int target) {
        if (start > end)
            return start;
                
        int mid = (start + end) / 2;
        if (nums[mid] < target)
            return binarySearch(nums, mid + 1, end, target);
        if (nums[mid] > target)
            return binarySearch(nums, start, mid - 1, target);
        return mid;
    }
}