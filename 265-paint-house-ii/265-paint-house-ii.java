class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        
        int min = Integer.MAX_VALUE;
        int secondMin = 0;
        int minColor = 0;
        
        for (int i=0; i<k; i++) {
            int cost = costs[0][i];
            if(cost < min) {
                secondMin = min;
                min = cost;
                minColor = i;
            } else if(cost < secondMin){
                secondMin = cost;
            }
        }
        
        for (int i=1; i<n; i++) {
            int tmpMin = Integer.MAX_VALUE;
            int tmpSecondMin = 0;
            int tmpMinColor = 0;
            for (int j=0; j<k; j++) {
                int cost = j==minColor? secondMin+costs[i][j]: min+costs[i][j];
                if(cost < tmpMin) {
                    tmpSecondMin = tmpMin;
                    tmpMin = cost;
                    tmpMinColor = j;
                } else if (cost < tmpSecondMin) {
                    tmpSecondMin = cost;
                }
            }
            min = tmpMin;
            secondMin = tmpSecondMin;
            minColor = tmpMinColor;
        }
        
        
        return min;
    }
}