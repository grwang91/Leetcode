class Solution {
    public String minWindow(String s1, String s2) {
        int[][] dp = new int[s2.length()][s1.length()];
        String ans = "";
        int len = Integer.MAX_VALUE;
        
        for (int i=0; i<dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        for (int i=0; i<dp.length; i++) {
            for (int j=0; j<dp[0].length; j++) {
                if(s1.charAt(j)==s2.charAt(i)) {
                    if(i>0) {
                        dp[i][j] = j>0? dp[i-1][j-1] : dp[i][j];
                    } else {
                        dp[i][j] = j;
                    }
                    
                    if(i==dp.length-1 && dp[i][j] != -1) {
                        if(j-dp[i][j]+1 < len) {
                            len = j-dp[i][j]+1;
                            ans = s1.substring(dp[i][j], j+1);
                        }
                    }
                } else {
                    if(j>0) {
                        dp[i][j] = dp[i][j-1];
                    }
                }
            }
        }
        
        return ans;
    }
}