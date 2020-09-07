class Solution {
    public void moveZeroes(int[] nums) {
        printArray(nums);
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                int j = i - 1;
                while (j >= 0 && nums[j] == 0) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    j--;
                }
            }
        }
    }
    
    private void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + ", ");
        System.out.println();
    }
}