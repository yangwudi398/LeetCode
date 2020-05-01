class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        
        int pivot = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1])
                pivot = i;
        }
        
        int last = nums[nums.length-1];
        if (target <= last)
            return binarySearch(nums, pivot, nums.length - 1, target);
        return binarySearch(nums, 0, pivot - 1, target);
        
    }
    
    public int binarySearch(int[] nums, int start, int end, int target) {
        if (start > end)
            return -1;
        
        int mid = (start + end) / 2;
        if (target < nums[mid])
            return binarySearch(nums, start, mid - 1, target);
        else if (target > nums[mid])
            return binarySearch(nums, start + 1, end, target);
        return mid;
    }
}