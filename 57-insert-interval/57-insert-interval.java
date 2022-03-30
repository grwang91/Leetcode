class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length==0) {
            return new int[][]{newInterval};
        } else if(intervals.length==1) {
            return merge(intervals[0], newInterval);
        }
        int[] merged = new int[2];
        int front = -1, end = -1;
        
        for(int i=0; i<intervals.length; i++) {
            if(intervals[i][1] >= newInterval[0]) {
                if(front == -1) {
                    front = i;
                }
            }
            if(newInterval[1] >= intervals[i][0]) {
                end = i;
            }
        }
        if(front == -1 || end == -1) {
            int[][] ans = new int[intervals.length+1][2];
            for(int i=0; i<intervals.length; i++) {
                ans[i] = intervals[i];
            }
            ans[intervals.length] = newInterval;
            Arrays.sort(ans, (i1,i2)->i1[0]==i2[0]? i1[1]-i2[1]: i1[0]-i2[0]);
            return ans;
        }
        
        int[][] ans = new int[intervals.length-(end-front)][2];
        int idx = 0;
        while(idx < front) {
            ans[idx] = intervals[idx];
            idx++;
        }
        ans[idx][0] = Math.min(intervals[front][0], newInterval[0]);
        ans[idx][1] = Math.max(intervals[end][1], newInterval[1]);
        idx++;
        
        for(int i=end+1; i<intervals.length; i++) {
            ans[idx++] = intervals[i];
        }
        
        return ans;
    }
    
    private int[][] merge(int[] a, int[] b) {
        if(a[0] > b[0]) {
            int[] tmp = a;
            a = b;
            b = tmp;
        }
        if(a[1] >= b[0]) {
            return new int[][]{{a[0], Math.max(a[1],b[1])}};
        }
        
        return new int[][]{a, b};
    }
}