class Solution {
    private List<List<Integer>> results = new ArrayList<>();
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(candidates, target, new ArrayList<>(), 0, 0);
        return this.results;
    }
    
    public void backTrack(int[] candidates, int target, List<Integer> currList, int currSum, int start) {
        for (int i = start; i < candidates.length; i++) {
            // ignore value if same as last one in the same iteration
            if (i > start && candidates[i] == candidates[i-1]) continue;
            int c = candidates[i];
            
            if (currSum + c < target) {
                currList.add(c);
                backTrack(candidates, target, currList, currSum + c, i + 1);
                currList.remove(currList.size() - 1);
            } else if (currSum + c == target) {
                currList.add(c);
                List<Integer> copyList = new ArrayList<>();
                copyList.addAll(currList);
                this.results.add(copyList);
                currList.remove(currList.size() - 1);
            }
        }
    }
}