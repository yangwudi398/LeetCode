class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int curr = 0;
        
        while (curr <= right) {
            if (nums[curr] == 0) {
                nums[curr] = nums[left];
                nums[left] = 0;
                left++;
                curr++;
                
            }
            else if (nums[curr] == 2) {
                nums[curr] = nums[right];
                nums[right] = 2;
                right--;
            } 
            else curr++;
        }
    }
}