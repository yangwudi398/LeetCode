class Solution {
    private HashMap<Character, String> phoneMap = new HashMap<>();
    private List<String> combinations = new ArrayList<>();
    
    public List<String> letterCombinations(String digits) {
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
        
        if (digits.length() > 0) {
            backTrace("", digits);
        }
        return combinations;
    }
    
    public void backTrace(String combination, String digitsLeft) {
        if (digitsLeft.length() == 0) {
            combinations.add(combination);
        } else {
            char digit = digitsLeft.charAt(0);
            String letters = phoneMap.get(digit);
            
            for (char ch: letters.toCharArray()) {
                backTrace(combination + ch, digitsLeft.substring(1));
            }
        }
    }
}