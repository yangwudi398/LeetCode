class Solution {
    public int climbStairs(int n) {
        int[] numWays = new int[n];
        for (int i = 0; i < n; i++)
            numWays[i] = -1;
        
        return climb(numWays, 0, n);
    }
    
    private int climb(int[] numWays, int step, int n) {
        if (step > n)
            return 0;
        if (step == n)
            return 1;
        if (numWays[step] >= 0)
            return numWays[step];
        
        int numWay = climb(numWays, step + 1, n) + climb(numWays, step + 2, n);
        numWays[step] = numWay;
        return numWay;
    }
}