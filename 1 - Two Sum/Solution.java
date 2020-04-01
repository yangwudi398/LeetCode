class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                int j = map.get(complement);
                if (i < j) return new int[]{i, j};
                else return new int[]{j, i};
            } 
            map.put(nums[i], i);
        }
        return new int[0];
    }
}