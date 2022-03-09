class LockingTree {
    List<List<Integer>> graph;
    Map<Integer,Integer> locked;
    int[] parent;
    public LockingTree(int[] parent) {
        graph = new ArrayList<>();
        locked = new HashMap<>();
        this.parent = parent;
        
        for(int i=0; i<parent.length; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<parent.length; i++) {
            if(parent[i] == -1) continue;
            
            graph.get(parent[i]).add(i);
        }
    }
    
    public boolean lock(int num, int user) {
        if(locked.containsKey(num)) return false;
        
        locked.put(num, user);
        return true;
    }
    
    public boolean unlock(int num, int user) {
        if(!locked.containsKey(num) || locked.get(num) != user) return false;
        
        locked.remove(num);
        return true;
    }
    
    public boolean upgrade(int num, int user) {
        if(locked.containsKey(num)) return false;
        
        int curr = num;
        while(curr != -1) {
        
            curr = parent[curr];
            
            if(locked.containsKey(curr)) return false;
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        boolean atLeastOneLocked = false;
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int next: graph.get(cur)) {
                if(locked.containsKey(next)) {
                    atLeastOneLocked = true;
                }
                q.add(next);
                locked.remove(next);
            }
        }
        if(!atLeastOneLocked) return false;
        
        locked.put(num, user);
        return true;
    }
    
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */