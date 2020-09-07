class WordDistance {
    private int length;
    private Map<String, List<Integer>> locations  = new HashMap<>();

    public WordDistance(String[] words) {
        this.length = words.length;
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!this.locations.containsKey(word)) 
                this.locations.put(word, new ArrayList<Integer>());
            this.locations.get(word).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> list1 = this.locations.get(word2);
        List<Integer> list2 = this.locations.get(word1);
        
        int p1 = 0, p2 = 0;
        int shortest = this.length;
        
        while (p1 < list1.size() && p2 < list2.size()) {
            int idx1 = list1.get(p1);
            int idx2 = list2.get(p2);
            int diff = Math.abs(idx1 - idx2);
            
            if (diff < shortest)
                shortest = diff;
            if (idx1 < idx2)
                p1++;
            else
                p2++;
        }
        
        return shortest;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */