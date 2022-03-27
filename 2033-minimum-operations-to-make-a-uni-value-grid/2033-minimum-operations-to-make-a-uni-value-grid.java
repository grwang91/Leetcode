class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> arr = new ArrayList<>();
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                arr.add(grid[i][j]);
            }
        }
        Collections.sort(arr);
        int m = arr.size()/2;
        int ans = 0;
        
        for(int i=0; i<arr.size(); i++) {
            int diff = Math.abs(arr.get(i)-arr.get(m));
            if(diff%x != 0) return -1;
            ans+=diff/x;
        }
        
        return ans;
    }
}