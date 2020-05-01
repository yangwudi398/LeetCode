class Solution {
    public String countAndSay(int n) {
        String nums = "1";
        for (int i = 1; i < n; i++) {
            nums = say(nums);
        }
        return nums;
    }
    
    public String say(String nums) {
        char curNum = nums.charAt(0);
        int curCount = 1;
        String result = "";
        
        for (int i = 1; i < nums.length(); i++) {
            char num = nums.charAt(i);
            if (num == curNum)
                curCount += 1;
            else {
                result += String.valueOf(curCount) + curNum;
                curNum = num;
                curCount = 1;
            }
        }
        result += String.valueOf(curCount) + curNum;
        
        return result;
    }
}