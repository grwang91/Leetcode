class Solution {
    int[][] rects;
    Random rand;
    int totalArea = 0;
    TreeMap<Integer,Integer> map;
    public Solution(int[][] rects) {
        this.rects = rects;
        rand = new Random();
        map = new TreeMap<>();
        
        for (int i=0; i<rects.length; i++) {
            int[] rect = rects[i];
            int length = rect[2]-rect[0]+1;
            int width = rect[3]-rect[1]+1;
            totalArea+=length*width;
            map.put(totalArea,i);
        }
    }
    
    public int[] pick() {
        int key = map.ceilingKey(rand.nextInt(totalArea) + 1);
        int rectNum = map.get(key);
        int x1 = rects[rectNum][0];
        int y1 = rects[rectNum][1];
        int x2 = rects[rectNum][2];
        int y2 = rects[rectNum][3];
        int x = x1 + rand.nextInt(x2-x1+1);
        int y = y1 + rand.nextInt(y2-y1+1);
        
        return new int[]{x,y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */