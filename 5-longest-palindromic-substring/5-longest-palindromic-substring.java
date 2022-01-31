class Solution {
    public String longestPalindrome(String s) {
        int maxLength = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int start = 0;
        int end = 0;
        
        for (int i=0; i<dp.length; i++) {
            dp[i][i] = true;
        }
        
        for (int i=s.length()-1; i>=0; i--) {
            for (int j=i+1; j<s.length(); j++) {
                if(s.charAt(i) != s.charAt(j)) {
                    continue;
                }
                
                if(j-i==1 || dp[i+1][j-1]) {
                    dp[i][j] = true;
                    if(j-i+1 > maxLength) {
                        maxLength = j-i+1;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start,end+1);
    }
}