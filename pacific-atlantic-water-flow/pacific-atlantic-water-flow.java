class Solution {
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> output = new ArrayList<>();
        
        int[][] ocean = new int[heights.length][heights[0].length];
        for (int i=0; i<ocean.length; i++) {
            Arrays.fill(ocean[i],-1);
        }
        
        for (int i=0; i<heights.length; i++) {
            for (int j=0; j<heights[0].length; j++) {
                if(i==0 && j==heights[0].length-1 || i==heights.length-1 && j==0) {
                    dfs(i,j,heights,ocean,3);
                } else if (i==0 || j==0) {
                    if(heights.length == 1 || heights[0].length==1) {
                        dfs(i,j,heights,ocean,3);
                    } else {
                        dfs(i,j,heights,ocean,1);
                    }
                    
                } else if (i==heights.length-1 || j==heights[0].length-1) {
                    dfs(i,j,heights,ocean,2);
                }
            }
        }
        
        for (int i=0; i<ocean.length; i++) {
            for (int j=0; j<ocean[0].length; j++) {
                // System.out.print(ocean[i][j] + "    ");
                if(ocean[i][j] == 3) {
                    output.add(new ArrayList<>(Arrays.asList(i,j)));
                }
            }
            // System.out.println();
        }
        
        return output;
    }
    
    private void dfs(int row, int col, int[][] heights, int[][] ocean, int check) {
        
        if(ocean[row][col] == check || ocean[row][col] == 3)
            return;
        if(ocean[row][col] == -1) {
            ocean[row][col] = check;
        } else if (ocean[row][col]!= check) {
            ocean[row][col] = 3;
        }
        
        for (int i=0; i<4; i++) {
            int nRow = row + dir[i][0];
            int nCol = col + dir[i][1];
            
            if(nRow>=0 && nRow < heights.length && nCol>=0 && nCol<heights[0].length && heights[row][col] <= heights[nRow][nCol]) {
                dfs(nRow,nCol,heights,ocean,check);
            }
        }
    }

}