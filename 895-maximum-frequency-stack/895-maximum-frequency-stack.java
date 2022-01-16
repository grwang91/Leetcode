class FreqStack {
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> stacks;
    int maxFreq;

    public FreqStack() {
        freq = new HashMap<>();
        stacks = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int f = freq.getOrDefault(val,0)+1;
        freq.put(val,f);
        maxFreq = Math.max(maxFreq, f);
        
        stacks.putIfAbsent(f, new Stack<>());
        stacks.get(f).push(val);
    }
    
    public int pop() {
        int out = stacks.get(maxFreq).pop();
        freq.put(out, freq.get(out)-1);
        if(stacks.get(maxFreq).isEmpty()) {
            maxFreq--;
        }
        
        return out;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */