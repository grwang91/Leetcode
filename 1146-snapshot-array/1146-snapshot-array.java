class SnapshotArray {
    int count;
    Map<Integer, Map<Integer, Integer>> snapShot;
    Map<Integer, Integer> map;
    public SnapshotArray(int length) {
        this.count = 0;
        snapShot = new HashMap<>();
        map = new HashMap<>();
    }
    
    public void set(int index, int val) {
        map.put(index, val);
    }
    
    public int snap() {
        snapShot.put(count, new HashMap<Integer, Integer>(map));
        return count++;
    }
    
    public int get(int index, int snap_id) {
        return snapShot.get(snap_id).getOrDefault(index,0);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */