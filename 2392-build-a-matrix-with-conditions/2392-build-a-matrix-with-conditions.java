class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] rowIndegree = new int[k+1];
        int[] colIndegree = new int[k+1];
        Map<Integer, List<Integer>> rowMap = new HashMap<>();
        Map<Integer, List<Integer>> colMap = new HashMap<>();
        int[][] ans = new int[k][k];
        int[] c = new int[k+1];
        Arrays.fill(c, -1);
        int[] r = new int[k+1];
        Arrays.fill(r, -1);
        
        for(int[] row: rowConditions) {
            rowIndegree[row[0]]++;
            rowMap.computeIfAbsent(row[1], kk-> new ArrayList<>()).add(row[0]);
        }
        
        for(int[] col: colConditions) {
            colIndegree[col[0]]++;
            colMap.computeIfAbsent(col[1], kk-> new ArrayList<>()).add(col[0]);
        }
        
        for(int i=k-1; i>=0; i--) {
            for(int j=1; j<=k; j++) {
                if(rowIndegree[j] == 0) {
                    r[j] = i;
                    rowIndegree[j] = -1;
                    if(rowMap.containsKey(j)) {
                        for(int n: rowMap.get(j)) {
                            rowIndegree[n]--;
                        }    
                    }
                    break;
                }
            }
        }
        for(int i=k-1; i>=0; i--) {
            for(int j=1; j<=k; j++) {
                if(colIndegree[j] == 0) {
                    c[j] = i;
                    colIndegree[j] = -1;
                    if(colMap.containsKey(j)) {
                        for(int n: colMap.get(j)) {
                            colIndegree[n]--;
                        }
                    }
                    break;
                }
            }
        }
        
        for(int i=1; i<=k; i++) {
            int rr = r[i];
            int cc = c[i];
            if(rr == -1 || cc == -1) {
                return new int[0][0];
            }
            ans[rr][cc] = i;
        }
        return ans;
    }
}