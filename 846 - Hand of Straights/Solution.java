class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        TreeMap<Integer, Integer> counts = new TreeMap<>();
        for (int i = 0; i < hand.length; i++) {
            int card = hand[i];
            if (!counts.containsKey(card))
                counts.put(card, 1);
            else
                counts.replace(card, counts.get(card) + 1);
        }
        
        while (counts.size() > 0) {
            int first = counts.firstKey();
            for (int key = first; key < first + W; key++) {
                if (!counts.containsKey(key))
                    return false;
                counts.replace(key, counts.get(key) - 1);
                if (counts.get(key) == 0)
                    counts.remove(key);
            }
        }
        
        return true;
    }
}