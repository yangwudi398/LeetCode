class Solution {
    private List<List<Integer>> results = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> currList = new ArrayList<>();
        backTrack(candidates, target, currList, 0, 0);
        return this.results;
    }
    
    public void backTrack(int[] candidates, int target, List<Integer> currList, int currSum, int start) {
        for (int i = start; i < candidates.length; i++) {
            int c = candidates[i];
            if (currSum + c < target) {
                currList.add(c);
                backTrack(candidates, target, currList, currSum + c, i);
                currList.remove(currList.size() - 1);
            } else if (currSum + c == target) {
                currList.add(c);
                List<Integer> copyList = new ArrayList<>(currList.size());
                copyList.addAll(currList);
                this.results.add(copyList);
                currList.remove(currList.size() - 1);
            }
        }
    }
}