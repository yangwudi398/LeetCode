class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();
        
        if (numRows == 0)
            return pascal;
        
        List<Integer> prevRow = new ArrayList<>();
        prevRow.add(1);
        
        for (int i = 1; i < numRows; i++) {
            List<Integer> currRow = new ArrayList<>();
            currRow.add(1);
            
            for (int j = 1; j < prevRow.size(); j++) 
                currRow.add(prevRow.get(j - 1) + prevRow.get(j));
            
            currRow.add(1);
            
            pascal.add(prevRow);
            prevRow = currRow;
        }
        pascal.add(prevRow);
        
        return pascal;
    }
}