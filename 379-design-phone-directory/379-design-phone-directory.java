class PhoneDirectory {
    Map<Integer, Boolean> map;
    public PhoneDirectory(int maxNumbers) {
        map = new HashMap<>();
        
        for(int i=0; i<maxNumbers; i++) {
            map.put(i,true);
        }
    }
    
    public int get() {
        if(map.size()==0) {
            return -1;
        }
        int selected = 0;
        for(int number: map.keySet()) {
            selected = number;
            break;
        }
        map.remove(selected);
        return selected;
    }
    
    public boolean check(int number) {
        return map.containsKey(number);
    }
    
    public void release(int number) {
        map.put(number, true);
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */