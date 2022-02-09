class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[n][k];
        
        int min = Integer.MAX_VALUE;
        int secondMin = 0;
        int minColor = 0;
        
        for (int i=0; i<k; i++) {
            dp[0][i] = costs[0][i];
            if(dp[0][i] < min) {
                secondMin = min;
                min = dp[0][i];
                minColor = i;
            } else if(dp[0][i] < secondMin){
                secondMin = dp[0][i];
            }
        }
        
        for (int i=1; i<n; i++) {
            int tmpMin = Integer.MAX_VALUE;
            int tmpSecondMin = 0;
            int tmpMinColor = 0;
            for (int j=0; j<k; j++) {
                dp[i][j] = j==minColor? secondMin+costs[i][j]: min+costs[i][j];
                if(dp[i][j] < tmpMin) {
                    tmpSecondMin = tmpMin;
                    tmpMin = dp[i][j];
                    tmpMinColor = j;
                } else if (dp[i][j] < tmpSecondMin) {
                    tmpSecondMin = dp[i][j];
                }
            }
            min = tmpMin;
            secondMin = tmpSecondMin;
            minColor = tmpMinColor;
        }
        
        
        return min;
    }
}