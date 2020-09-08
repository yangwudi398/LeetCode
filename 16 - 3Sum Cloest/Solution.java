class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        
        for (int i = 0; i < nums.length - 2; i++) {
            int p2 = i + 1, p3 = nums.length - 1;
            
            while(p2 < p3) {
                int sum = nums[i] + nums[p2] + nums[p3];

                if (sum < target) {
                    p2++;
                } else if (sum > target) {
                    p3--;
                } else {
                    return sum;
                }
                
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        
        return result;
    }
}