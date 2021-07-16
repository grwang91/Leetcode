class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> output = new ArrayList<>();
        
        for (int i=0; i<grid.length; i++) {
            output.add(new ArrayList<>());
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int i=grid.length-1; i>=0; i--) {
            for(int j=grid[0].length-1; j>=0; j--) {
                q.add(grid[i][j]);
            }
        }
        
        for (int i=0; i<k; i++) {
            q.add(q.poll());
        }
        Stack<Integer> stack = new Stack<>();
        
        while(!q.isEmpty()) {
            stack.push(q.poll());
        }
        
        int row = 0;
        int col = 0;
        // System.out.println(stack.size());
        
        while(!stack.isEmpty()) {
            output.get(row).add(stack.pop());
            col++;
            
            if(col == grid[0].length) {
                row++;
                col = 0;
            }
        }
        return output;
    }
}