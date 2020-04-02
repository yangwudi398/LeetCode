class Solution {
    public int findMinMoves(int[] machines) {
        int n = machines.length;
        
        int total = 0;
        for (int i = 0; i < n; i++)
            total += machines[i];

        if (total % n != 0)
            return -1;
        
        int steps = 0;
        int max = 0;
        int average = total / n;
        
        for (int i = 0 ; i < n; i++) {
            steps += machines[i] - average;;
            max = Math.max(max, Math.max(machines[i] - average, Math.abs(steps)));       
        }
        
        return max;
    }
}