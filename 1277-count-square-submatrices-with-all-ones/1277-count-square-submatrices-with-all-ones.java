class Solution {
    public int countSquares(int[][] matrix) {
        int[][] prefix = new int[matrix.length+1][matrix[0].length+1];
        int ans = 0;
        
        for(int i=1; i<=matrix.length; i++) {
            for (int j=1; j<=matrix[0].length; j++) {
                prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1] + matrix[i-1][j-1];
            }
        }
        
        for(int i=1; i<prefix.length; i++) {
            for(int j=1; j<prefix[0].length; j++) {
                for(int k=1; k<=matrix.length; k++) {
                    if(j+k-1 >= prefix[0].length || i+k-1 >= prefix.length) continue;
                    int val = sum(prefix, i, j, k);
                    if(val == k*k) {
                        
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    
    private int sum(int[][] prefix, int r, int c, int n) {
        return prefix[r+n-1][c+n-1] - prefix[r-1][c+n-1] - prefix[r+n-1][c-1] + prefix[r-1][c-1];
    }
}