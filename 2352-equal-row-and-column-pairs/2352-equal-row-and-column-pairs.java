class Solution {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> row = new HashMap<>();
        Map<String, Integer> col = new HashMap<>();
        int ans = 0;
        
        for(int i=0; i<grid.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<grid[0].length; j++) {
                sb.append(grid[i][j]+"#");
            }
            String s = sb.toString();
            row.put(s, row.getOrDefault(s,0)+1);
        }
        
        for(int j=0; j<grid[0].length; j++) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<grid.length; i++) {
                sb.append(grid[i][j]+"#");
            }
            String s = sb.toString();
            col.put(s, col.getOrDefault(s,0)+1);
        }
        
        for(String key: row.keySet()) {
            int r = row.get(key);
            int c = col.getOrDefault(key,0);
            ans+=r*c;
        }
        
        return ans;
    }
}