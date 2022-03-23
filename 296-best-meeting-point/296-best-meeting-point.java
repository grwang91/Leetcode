class Solution {
    public int minTotalDistance(int[][] grid) {
        int[] horizontal = new int[grid[0].length];
        int[] vertical = new int[grid.length];
        List<Integer> column = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        
        int initHoriDist = 0;
        int initVertiDist = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    column.add(j);
                    row.add(i);
                    initHoriDist+=j;
                    initVertiDist+=i;
                }
            }
        }
        Collections.sort(column);
        Collections.sort(row);
        
        horizontal[0] = initHoriDist;
        vertical[0] = initVertiDist;
        
        int idx = 0;
        for(int i=1; i<horizontal.length; i++) {
            idx = Math.max(idx, 0);
            while(idx < column.size() && column.get(idx) < i) {
                idx++;
            }
            idx--;
            horizontal[i]=horizontal[i-1]+(idx+1)-(column.size()-idx-1);
        }
        
        idx = 0;
        for(int i=1; i<vertical.length; i++) {
            idx = Math.max(idx, 0);
            while(idx < row.size() && row.get(idx) < i) {
                idx++;
            }
            idx--;
            vertical[i]=vertical[i-1]+(idx+1)-(row.size()-idx-1);
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<horizontal.length; i++) {
            for(int j=0; j<vertical.length; j++) {
                ans = Math.min(ans, horizontal[i]+vertical[j]);
            }
        }
        
        return ans;
        
    }
}