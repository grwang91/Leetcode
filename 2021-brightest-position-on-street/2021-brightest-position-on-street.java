class Solution {
    public int brightestPosition(int[][] lights) {
        PriorityQueue<Integer> start = new PriorityQueue<>();
        PriorityQueue<Integer> end = new PriorityQueue<>();
        for(int i=0; i<lights.length; i++) {
            int s = lights[i][0]-lights[i][1];
            int e = lights[i][0]+lights[i][1];
            start.add(s);
            end.add(e);
        }
        
        int overlap = 0;
        int ans = 0;
        int curOverlap = 0;
        
        while(!start.isEmpty()) {
            int cur = start.poll();
            curOverlap++;
            
            while(end.peek() < cur) {
                end.poll();
                curOverlap--;
            }
            if(curOverlap > overlap) {
                overlap = curOverlap;
                ans = cur;
            }
        }
        return ans;
    }
}