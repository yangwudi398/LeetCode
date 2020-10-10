class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Map<Integer, Set<Integer>> graph = createGraph(connections);
        
        List<List<Integer>> criticals = new ArrayList<>();
        
        for (List<Integer> edge: connections) {
            if (isCritical(n, edge, graph)) {
                List<Integer> conn = new ArrayList<>();
                conn.add(edge.get(0));
                conn.add(edge.get(1));
                criticals.add(conn);
            }
        }
        
        return criticals;
    }
    
    private Map<Integer, Set<Integer>> createGraph(List<List<Integer>> connections) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        
        for (List<Integer> edge: connections) {
            int v1 = edge.get(0);
            int v2 = edge.get(1);
            
            if (!graph.containsKey(v1)) 
                graph.put(v1, new HashSet<Integer>());
            graph.get(v1).add(v2);
            
            if (!graph.containsKey(v2))
                graph.put(v2, new HashSet<Integer>());
            graph.get(v2).add(v1);
        }
        
        return graph;
    }
    
    private boolean isCritical(int n, List<Integer> edge, Map<Integer, Set<Integer>> graph) {
        int v1 = edge.get(0);
        int v2 = edge.get(1);
            
        graph.get(v1).remove(v2);
        graph.get(v2).remove(v1);
            
        boolean[] connected = new boolean[n];
        DFS(connected, 0, graph);
        
        graph.get(v1).add(v2);
        graph.get(v2).add(v1);
            
        for (int i = 0; i < connected.length; i++) {
            if (!connected[i])
                return true;
        }
        return false;
    }
    
    private void DFS(boolean[] connected, int start, Map<Integer, Set<Integer>> graph) {
        connected[start] = true;
        
        Set<Integer> neighbors = graph.get(start);
        for (int neighbor: neighbors) {
            if (!connected[neighbor]) 
                DFS(connected, neighbor, graph);
        }
    }
}