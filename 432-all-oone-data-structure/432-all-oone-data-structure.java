class AllOne {
    Map<String, Integer> count;
    TreeMap<Integer, Set<String>> map;
    int max;
    int min;

    public AllOne() {
        count = new HashMap<>();
        map = new TreeMap<>();
    }
    
    public void inc(String key) {
        count.put(key, count.getOrDefault(key,0)+1);
        int cnt = count.get(key);
        map.computeIfAbsent(cnt, k->new HashSet<>()).add(key);
        if(cnt > 1) {
            map.get(cnt-1).remove(key);
            if(map.get(cnt-1).size()==0) {
                map.remove(cnt-1);
            }
        }
    }
    
    public void dec(String key) {
        int cnt = count.get(key);
        count.put(key, count.get(key)-1);
        
        map.get(cnt).remove(key);
        if(cnt > 1) {
            map.computeIfAbsent(cnt-1, k->new HashSet<>()).add(key);
        } else {
            count.remove(key);
        }
        
        if(map.get(cnt).size()==0) {
            map.remove(cnt);
        }
    }
    
    public String getMaxKey() {
        if(map.isEmpty()) {
            return "";
        }
        Set<String> set = map.lastEntry().getValue();
        Iterator iter = set.iterator();
        while(iter.hasNext()) {
            return (String)iter.next();
        }
        return "";
    }
    
    public String getMinKey() {
        if(map.isEmpty()) {
            return "";
        }
        Set<String> set = map.firstEntry().getValue();
        Iterator iter = set.iterator();
        while(iter.hasNext()) {
            return (String)iter.next();
        }
        return "";
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */