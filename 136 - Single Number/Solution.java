class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length / 2 + 1);
        for (int n: nums) {
            if (map.containsKey(n))
                map.put(n, 2);
            else
                map.put(n, 1);
        }
        
        Set<Integer> keys = map.keySet();
        for (int n: keys)
            if (map.get(n) == 1)
                return n;
        
        return 0;
    }
}