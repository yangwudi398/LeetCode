class Solution {
    public String intToRoman(int num) {
        String roman = "";
        
        int count1000 = num / 1000;
        num = num % 1000;
        
        int count100 = num / 100;
        num = num % 100;
        
        int count10 = num / 10;
        num = num % 10;
        
        int countI = num;
        
        for (int i = 0; i < count1000; i++) {
            roman += "M";
        }
        
        if (count100 < 4) {
            for (int i = 0; i < count100; i++) {
                roman += "C";
            }
        } else if (count100 == 4) {
            roman += "CD";
        } else if (count100 < 9) {
            roman += "D";
            for (int i = 0; i < count100 - 5; i++) {
                roman += "C";
            }
        } else {
            roman += "CM";
        }
        
        if (count10 < 4) {
            for (int i = 0; i < count10; i++) {
                roman += "X";
            }
        } else if (count10 == 4) {
            roman += "XL";
        } else if (count10 < 9) {
            roman += "L";
            for (int i = 0; i < count10 - 5; i++) {
                roman += "X";
            }
        } else {
            roman += "XC";
        }
        
        if (countI < 4) {
            for (int i = 0; i < countI; i++) {
                roman += "I";
            }
        } else if (countI == 4) {
            roman += "IV";
        } else if (countI < 9) {
            roman += "V";
            for (int i = 0; i < countI - 5; i++) {
                roman += "I";
            }
        } else {
            roman += "IX";
        }
        
        return roman;
    }
}