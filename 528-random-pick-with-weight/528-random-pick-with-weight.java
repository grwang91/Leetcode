class Solution {
    int sum;
    int[] weight;
    
    public Solution(int[] w) {
        weight = new int[w.length];
        sum = 0;
        for (int i=0; i<w.length; i++) {
            sum+=w[i];
            weight[i] = sum;
        }
    }
    
    public int pickIndex() {
        double target = sum*Math.random();
        
        int s = 0, e = weight.length;
        int idx = 0;
        while(s<e) {
            int m = (s+e)/2;
            
            if(weight[m] < target) {
                idx = Math.max(idx, m);
                s = m+1;
            } else {
                e = m;
            }
        }
        return s;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */