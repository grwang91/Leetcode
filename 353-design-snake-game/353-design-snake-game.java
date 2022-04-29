class SnakeGame {
    Map<Integer, Set<Integer>> body;
    Queue<Pair> q;
    int width;
    int height;
    int[][] food;
    int idx;
    int r, c;
    public SnakeGame(int width, int height, int[][] food) {
        body = new HashMap<>();
        q = new LinkedList<>();
        this.width = width;
        this.height = height;
        this.food = food;
        idx = 0;
        r = 0;
        c = 0;
        q.add(new Pair(0,0));
        body.computeIfAbsent(0, k -> new HashSet<>()).add(0);
    }
    
    public int move(String direction) {
        if(direction.equals("R")) {
            c++;
        } else if(direction.equals("L")) {
            c--;
        } else if(direction.equals("U")) {
            r--;
        } else {
            r++;
        }
        
        if(idx < food.length && food[idx][0]==r && food[idx][1]==c) {
            idx++;
        } else {
            Pair cur = q.poll();
            body.get(cur.r).remove(cur.c);
        }
        
        if(r< 0 || r>=height || c<0 || c>=width || body.containsKey(r) && body.get(r).contains(c)) {
            return -1;
        }
        q.add(new Pair(r,c));
        body.computeIfAbsent(r, k->new HashSet<>()).add(c);
        
        return q.size()-1;
    }
    
    class Pair {
        int r;
        int c;
        
        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */