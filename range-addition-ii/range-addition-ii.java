class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int maxRow = m;
        int maxCol = n;
        
        for (int[] op : ops) {
            maxRow = Math.min(maxRow,op[0]);
            maxCol = Math.min(maxCol,op[1]);
        }
        
        return maxRow*maxCol;
    }
}