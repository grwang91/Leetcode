class Solution {
    public int smallestCommonElement(int[][] mat) {
        int ans = Integer.MAX_VALUE;
        Set<Integer> common = null;
        
        for(int i=0; i<mat.length; i++) {
            Set<Integer> tmp = new HashSet<>();
            for(int j=0; j<mat[0].length; j++) {
                if(i==0) {
                    tmp.add(mat[i][j]);
                    continue;
                }
                if(common.contains(mat[i][j])) {
                    tmp.add(mat[i][j]);
                    if(i==mat.length-1) {
                        ans = Math.min(ans,mat[i][j]);
                    }
                }
                
            }
            common = tmp;
        }
        
        return ans == Integer.MAX_VALUE? -1: ans;
    }
}