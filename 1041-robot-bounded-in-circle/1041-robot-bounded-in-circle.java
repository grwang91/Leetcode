class Solution {
    public boolean isRobotBounded(String instructions) {
        Node after = afterCycle(new Node(0,0,0), instructions);
        
        return after.x==0 && after.y==0 || after.dir != 0;
    }
    
    private Node afterCycle(Node current, String instructions) {
        for (char c : instructions.toCharArray()) {
            if(c=='G') {
                if(current.dir == 0) {
                    current.y++;
                } else if (current.dir==1) {
                    current.x--;
                } else if (current.dir==2) {
                    current.y--;
                } else {
                    current.x++;
                }
            } else if (c=='L') {
                current.dir = (current.dir+1)%4;
            } else {
                current.dir = (current.dir+3)%4;
            }
        }
        
        return current;
    }
    
    class Node{
        int x, y, dir;
        // 0-> north, 1->west 2->south 3->east
        
        public Node(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}