class Solution {
    public int countPrimes(int n) {
        boolean[] prime = new boolean[n];
        for (int i = 0; i < n; i++)
            prime[i] = true;
        
        for (int i = 2; i * i < n; i++) 
            if (prime[i]) 
                for (int j = 2; i * j < n; j++)
                    prime[i*j] = false;
        
        int count = 0;
        for (int i = 2; i < n; i++)
            if (prime[i])
                count++;
        return count;
    }
}