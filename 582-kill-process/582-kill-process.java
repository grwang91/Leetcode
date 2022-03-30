class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> arr = new ArrayList<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for(int i=0; i<pid.size(); i++) {
            int p = ppid.get(i);
            int c = pid.get(i);
            
            if(!graph.containsKey(p)) {
                graph.put(p, new ArrayList<>());
            }
            graph.get(p).add(c);
        }
        
        dfs(graph, kill, arr);
        
        return arr;
    }
    
    private void dfs(Map<Integer, List<Integer>> graph, int kill, List<Integer> arr) {
        arr.add(kill);
        if(graph.get(kill)==null) return;
        
        for(int next: graph.get(kill)) {
            dfs(graph, next, arr);
        }
    }
}