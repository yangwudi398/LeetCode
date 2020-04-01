class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            int index = binarySearch(numbers, i + 1, numbers.length - 1, complement);
            if (index > 0)
                return new int[]{i + 1, index + 1};
        }
        return new int[]{0, 0};
    }
    
    public int binarySearch(int[] numbers, int left, int right, int complement) {
        if (left > right) 
            return -1;
        
        int mid = (left + right) / 2;
        if (complement < numbers[mid])
            return binarySearch(numbers, left, mid - 1, complement);
        else if (complement > numbers[mid])
            return binarySearch(numbers, mid + 1, right, complement);
        return mid;
    }
}