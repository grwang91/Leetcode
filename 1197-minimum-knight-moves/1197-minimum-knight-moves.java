class Solution {
    int[][] dir = {{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1},{-2,1},{-1,2}};
    public int minKnightMoves(int x, int y) {
        Map<Integer, Set<Integer>> visited = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0, 0));
        if(!visited.containsKey(0)) {
            visited.put(0,new HashSet<>());
        }
        visited.get(0).add(0);
        
        while(!q.isEmpty()) {
            Pair cur = q.poll();
            // System.out.println(cur.x+" " +cur.y+" " + cur.moves);
            if(cur.x == x && cur.y == y) {
                return cur.moves;
            }
            
            for(int i=0; i<8; i++) {
                int nx = cur.x+dir[i][0];
                int ny = cur.y+dir[i][1];
                if(!visited.containsKey(nx)) {
                    visited.put(nx, new HashSet<>());
                }
                
                if(!visited.get(nx).contains(ny)) {
                    visited.get(nx).add(ny);
                    q.add(new Pair(nx, ny, cur.moves+1));
                }
            }
            
        }
        
        return -1;
    }
    
    class Pair {
        int x;
        int y;
        int moves;
        
        public Pair(int x, int y, int moves) {
            this.x = x;
            this.y = y;
            this.moves = moves;
        }
    }
}