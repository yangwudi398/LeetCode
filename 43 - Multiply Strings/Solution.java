class Solution {
    public String multiply(String num1, String num2) {
        int[] digits = new int[num1.length() + num2.length() - 1];
        
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                digits[i+j] += Integer.parseInt(num1.substring(i, i+1)) * Integer.parseInt(num2.substring(j, j+1));
            }
        }
        
        for (int d: digits) System.out.print(d + " ");
        System.out.println();
        
        StringBuilder result = new StringBuilder();
        int d0 = 0;
        int d1 = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            d0 = digits[i] % 10 + d1;
            result.append(d0 % 10);
            d1 = d0 / 10 + digits[i] / 10;
        }
        
        if (d1 > 0) {
            result.append(d1);
        }
        
        String product = result.reverse().toString();
        while (product.length() > 1 && product.charAt(0) == '0') {
            product = product.substring(1);
        } 

        return product;
    }
}