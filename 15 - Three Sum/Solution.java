class Solution {
    public List<List<Integer>> threeSum(int[] nums) {        
        List<List<Integer>> solutions = new ArrayList<>();
        if (nums.length < 3) return solutions;
        Arrays.sort(nums);
        
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }
        
        int first = nums[0] - 1;        
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == first) continue;
            if (nums[i] > 0) break;
            
            first = nums[i];            
            int target = -first;

            int second = nums[i + 1] - 1;
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[j] == second) continue;
                
                second = nums[j];
                int complement = target - second;
                
                if (numsMap.containsKey(complement) &&
                    numsMap.get(complement) > j) {
                    List<Integer> result = 
                        Arrays.asList(first, second, complement);
                    solutions.add(result);
                }
            }
        }
        
        return solutions;
    }
}