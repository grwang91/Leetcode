class Solution {
    public int minFallingPathSum(int[][] grid) {
        int min = 0;
        int minIdx = -1;
        int secondMin = 0;
        
        for (int i=0; i<grid.length; i++) {
            int nextMin = Integer.MAX_VALUE;
            int nextMinIdx = 0;
            int nextSecondMin = Integer.MAX_VALUE;
            for (int j=0; j<grid[0].length; j++) {
                int cur = j==minIdx? secondMin+grid[i][j]: min+grid[i][j];
                
                if(nextMin > cur) {
                    nextSecondMin = nextMin;
                    nextMin = cur;
                    nextMinIdx = j;
                } else {
                    nextSecondMin = Math.min(nextSecondMin, cur);
                }
            }
            min = nextMin;
            minIdx = nextMinIdx;
            secondMin = nextSecondMin;
        }
        return min;
    }
}