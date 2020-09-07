class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            if (clockwise(gas, cost, i))
                return i;
        }
        return -1;
        
    }
    
    public boolean clockwise(int[] gas, int[] cost, int start) {
        int currGas = 0;
        for (int i = start; i < gas.length; i++) {
            currGas += gas[i] - cost[i];
            if (currGas < 0) return false;
        }
        for (int i = 0; i < start; i++) {
            currGas += gas[i] - cost[i];
            if (currGas < 0) return false;
        }
        return true;
    }
}