class Solution {
    public int climbStairs(int n) {
        if (n == 0)
            return 1;
        if (n == 1 || n == 2)
            return n;
        
        int[] numWays = new int[n];
        numWays[0] = 1;
        numWays[1] = 2;
        
        for (int i = 2; i < n; i++) {
            numWays[i] = numWays[i-1] + numWays[i-2];
        }
        
        return numWays[numWays.length - 1];
    }
}