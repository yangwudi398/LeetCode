class Solution {
    public String getPermutation(int n, int k) {
        String results = "";
        
        List<Integer> nums = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) 
            nums.add(i);
        
        int factorial = factorial(n);
        k = k - 1;
        
        while (n > 0) {
            // get (n - 1)!
            factorial /= n--;
            // get index of the first digit
            int index = k / factorial;
            // retrive the first digit
            int digit = nums.get(index);
            // remove the first digit from digit list
            nums.remove(index);
            // append the first digit to results
            results += String.valueOf(digit);
            // set k's reminder to be new k
            k %= factorial;
        }
        
        return results;
    }
    
    private int factorial(int n) {
        if (n == 1)
            return 1;
        return n * factorial(n - 1);
    }
}