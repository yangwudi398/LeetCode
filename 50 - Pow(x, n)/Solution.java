class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            return getPow(1 / x, -n);
        }
        return getPow(x, n);
    }
    
    private double getPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n % 2 == 0)
            return getPow(x * x, n / 2);
        return x * getPow(x * x, n / 2);
    }
}