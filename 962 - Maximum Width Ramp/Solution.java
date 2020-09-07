class Solution {
    public int maxWidthRamp(int[] A) {
        Map<Integer, Deque<Integer>> map = new HashMap<>(A.length);
        for (int i = 0; i < A.length; i++) {
            if (!map.containsKey(A[i]))
                map.put(A[i], new LinkedList<Integer>());
            map.get(A[i]).offer(i);
        }
        
        Arrays.sort(A);
        
        int[] B = new int[A.length];
        int cur = 0;
        for (int i = 0; i < A.length; i++) {
            int index = map.get(A[i]).poll();
            B[cur++] = index;
        }
        
        int minPrev = A.length;
        int maxRamp = 0;
        for (int i = 0; i < B.length; i++) {
            maxRamp = Math.max(maxRamp, B[i] - minPrev);
            minPrev = Math.min(minPrev, B[i]);
        }
        
        return maxRamp;
    }
}