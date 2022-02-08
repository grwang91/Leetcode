class Solution {
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public void wallsAndGates(int[][] rooms) {
        
        for (int i=0; i<rooms.length; i++) {
            for (int j=0; j<rooms[0].length; j++) {
                if(rooms[i][j] == 0) {
                    bfs(rooms, i, j, new boolean[rooms.length][rooms[0].length]);
                }
            }
        }
    }
    
    private void bfs(int[][] rooms, int row, int col, boolean[][] check) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(row,col,0));
        check[row][col] = true;
        
        while(!q.isEmpty()) {
            Node current = q.poll();
            if(current.dist > rooms[current.row][current.col]) {
                continue;
            }
            rooms[current.row][current.col]=Math.min(current.dist, rooms[current.row][current.col]);
            
            for (int i=0; i<4; i++) {
                int nRow = current.row+dir[i][0];
                int nCol = current.col+dir[i][1];
                
                if(nRow>=0 && nRow<rooms.length && nCol>=0 && nCol<rooms[0].length && !check[nRow][nCol] && rooms[nRow][nCol] >0) {
                    q.add(new Node(nRow,nCol, current.dist+1));
                    check[nRow][nCol]= true;
                }
            }
        }
    }
    
    class Node {
        int row, col, dist;
        
        public Node(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
}