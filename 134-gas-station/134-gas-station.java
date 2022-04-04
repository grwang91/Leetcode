class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int cur = 0;
        int start = 0;
        
        for(int i=0; i<gas.length; i++) {
            if(cur < 0) {
                cur = 0;
                start = i;
            }
            total+=gas[i]-cost[i];
            cur+=gas[i]-cost[i];
        }
        
        return total>=0? start: -1;
    }
}