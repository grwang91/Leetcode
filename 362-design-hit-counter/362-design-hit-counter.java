class HitCounter {
    List<Integer> hits;
    
    public HitCounter() {
        hits = new ArrayList<>();
    }
    
    public void hit(int timestamp) {
        hits.add(timestamp);
        while(hits.size()>0 && hits.get(0) <= timestamp-300) {
            hits.remove(0);
        }
    }
    
    public int getHits(int timestamp) {
        int limit = findLimit(hits, timestamp-299);
        return limit==-1? 0: hits.size()-limit;
    }
    
    private int findLimit(List<Integer> hits, int timestamp) {
        int s = 0, e = hits.size();
        int out = Integer.MAX_VALUE;
        while(s<e) {
            int m = (s+e)/2;
            int time = hits.get(m);
            
            if(time >= timestamp) {
                out = Math.min(out, m);
                e = m;
            } else {
                s = m+1;
            }
        }
        return out==Integer.MAX_VALUE? -1: out;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */