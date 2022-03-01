class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (i1,i2)-> i1[1]-i2[1]);
        int ans = 0;
        int pre = 0;
        
        for(int i=1; i<intervals.length; i++) {
            if(intervals[pre][1] > intervals[i][0]) {
                ans++;
            } else {
                pre = i;
            }
        }
        
        return ans;
    }
}