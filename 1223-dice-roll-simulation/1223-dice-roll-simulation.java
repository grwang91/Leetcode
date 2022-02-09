class Solution {
    int MOD = 1000000007;
    public int dieSimulator(int n, int[] rollMax) {
        int[][][] consecutive = new int[n][7][16];
        int ans = 0;
        int[][] dp = new int[n][7];
        Arrays.fill(dp[0], 1);
        for (int i=1; i<=6; i++) {
            consecutive[0][i][1]++;
        }
        
        for (int i=1; i<n; i++) {
            for(int j=1; j<=6; j++) {
                for (int k=1; k<=6; k++) {
                    dp[i][k]=(dp[i][k]+dp[i-1][j])%MOD;
                    if(j==k) {
                        dp[i][k]-=consecutive[i-1][j][rollMax[j-1]];
                        dp[i][k]=(MOD+dp[i][k])%MOD;
                        for (int l=2; l<=15; l++) {
                            if(l>rollMax[j-1]) continue;
                            consecutive[i][j][l]=(consecutive[i][j][l]+consecutive[i-1][j][l-1])%MOD;
                        }
                    } else {
                        int sum = 0;
                        for (int p=1; p<=15; p++) {
                            sum=(sum+consecutive[i-1][j][p])%MOD;
                        }
                        consecutive[i][k][1]=(consecutive[i][k][1]+sum)%MOD;
                    }
                }
            }
        }
        // int aa = 3;
        for (int i=1; i<=6; i++) {
            ans=(ans+dp[n-1][i])%MOD;
            // System.out.print(dp[aa][i]+ " " );
        }
//         System.out.println();
        
//         for(int i=1; i<=6; i++) {
//             for (int j=1; j<=15; j++) {
//                 System.out.print(consecutive[aa][i][j]+ " ");
//             }
//             System.out.println();
//         }
        return ans;
    }
}