class Solution {
    public int mySqrt(int x) {
        if (x <= 1)
            return x;
        return binarySearch(x, 0, x);
    }
    
    private int binarySearch(int x, int low, int high) {
        int mid = (low + high) / 2;
        System.out.println(mid);
        
        if (mid == x / mid)
            return mid;
        
        if (mid < x / mid && (mid + 1) > x / (mid + 1))
            return mid;
        
        if (mid < x / mid)
            return binarySearch(x, mid + 1, high);
        
        return binarySearch(x, low, mid - 1);
    }
}