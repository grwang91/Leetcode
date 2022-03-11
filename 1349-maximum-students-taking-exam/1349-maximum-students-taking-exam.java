class Solution {
    int ans = 0;
    int[][] memo;
    public int maxStudents(char[][] seats) {
        boolean[][] map = new boolean[(1<<seats[0].length)][(1<<seats[0].length)];
        memo = new int[seats.length][(1<<seats[0].length)];
        for(int i=0; i<memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        
        check(map);
        return backTrack(map, seats, 0, 0);
    }
    
    private int backTrack(boolean[][] map, char[][] seats, int idx, int pre) {
        if(idx == seats.length) {
            return 0;
        }
        
        int max = 0;
        for(int i=0; i<map.length; i++) {
            if(map[pre][i] && seatAvailable(seats[idx], i)) {
                if(memo[idx][pre] != -1) {
                    return memo[idx][pre];
                }
                max = Math.max(max,countOnes(i)+backTrack(map, seats, idx+1, i));
            }
        }
        memo[idx][pre] = max;
        return max;
    }
    
    private int countOnes(int mask) {
        int n = 1;
        int ones = 0;
        while(n>0) {
            if((mask&n) != 0) {
                ones++;
            }
            n=n<<1;
        }
        return ones;
    }
    
    private boolean seatAvailable(char[] seat, int mask) {
        for(int i=0; i<seat.length; i++) {
            if((mask&(1<<seat.length-1-i)) != 0 && seat[i] == '#') {
                return false;
            }
        }
        return true;
    }
    
    private void check(boolean[][] map) {
        
        for(int i=0; i<map.length; i++) {
            if(!valid(i)) continue;
            for (int j=0; j<map.length; j++) {
                if(!valid(j)) continue;
                
                if(((i<<1)&j) == 0 && ((i>>1)&j) == 0) {
                    map[i][j] = true;
                }
            }
        }
    }
    
    private boolean valid(int seat) {
        int mask = 1;
        
        boolean pre = false;
        while(mask > 0) {
            if((mask&seat) == 0) {
                pre = false;
            } else {
                if(pre) return false;
                pre = true;
            }
            mask=mask<<1;
        }
        return true;
    }
}