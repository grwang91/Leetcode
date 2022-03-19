class Solution {
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int[][] dp = new int[floor.length()+1][numCarpets+1];
        
        for(int i=1; i<dp.length; i++) {
            for(int j=0; j<=numCarpets; j++) {
                int jump = dp[i-1][j] + floor.charAt(i-1)-'0';
                int cover = j > 0? dp[Math.max(i-carpetLen, 0)][j-1]: 1000;
                dp[i][j] = Math.min(jump, cover);
            }
        }
        
        return dp[floor.length()][numCarpets];
    }
}