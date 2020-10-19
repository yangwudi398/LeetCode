class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> partitions = new ArrayList<>();
        backtrack(partitions, new ArrayList<>(), s, 0);
        return partitions;
    }
    
    private void backtrack(List<List<String>> partitions, List<String> currList, String s, int start) {
        if (start >= s.length()) {
            List<String> partition = new ArrayList<>();
            partition.addAll(currList);
            partitions.add(partition);
        }
        
        for (int i = start ; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                currList.add(s.substring(start, i + 1));
                backtrack(partitions, currList, s, i + 1);
                currList.remove(currList.size() - 1);
            }
        }
    }
    
    // Check if the substring is a palindrome
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
    
    private void printList(List<String> list) {
        System.out.print("[");
        for (int i = 0; i < list.size() - 1; i++)
            System.out.print(list.get(i) + ", ");
        System.out.println(list.get(list.size() - 1) + "]");
    }
}