class Solution {
    public int maxHeight(int[][] cuboids) {
        int ans = 0;
        for (int i=0; i<cuboids.length; i++) {
            Arrays.sort(cuboids[i]);
        }
        
        Arrays.sort(cuboids, (c1,c2)-> {
            if(c1[0]!=c2[0]) return c1[0]-c2[0];
            if(c1[1]!=c2[1]) return c1[1]-c2[1];
            return c1[2]-c2[2];
        });
        int[] dp = new int[cuboids.length];
        
        for(int i=0; i<cuboids.length; i++) {
            dp[i] = cuboids[i][2];
            for (int j=i-1; j>=0; j--) {
                if(cuboids[i][1] >= cuboids[j][1] && cuboids[i][2] >= cuboids[j][2]) {
                    dp[i] = Math.max(dp[i], dp[j]+cuboids[i][2]);
                }
            }
            ans = Math.max(ans,dp[i]);
        }
        
        return ans;
    }
}