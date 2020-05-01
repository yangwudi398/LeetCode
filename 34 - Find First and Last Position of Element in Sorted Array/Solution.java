class Solution {
    private int start = -1;
    private int end = -1;
    
    public int[] searchRange(int[] nums, int target) {
        binarySearch(nums, 0, nums.length - 1, target);
        return new int[]{this.start, this.end};
    }
    
    public void binarySearch(int[] nums, int start, int end, int target) {
        if (start > end) return;
        
        int mid = (end + start) / 2;
        if (target < nums[mid])
            binarySearch(nums, start, mid - 1, target);
        else if (target > nums[mid])
            binarySearch(nums, mid + 1, end, target);
        else {
            if (this.start == -1 || mid < this.start)
                this.start = mid;
            if (this.end == -1 || mid > this.end)
                this.end = mid;
            binarySearch(nums, start, mid - 1, target);
            binarySearch(nums, mid + 1, end, target);
        }
    }
}