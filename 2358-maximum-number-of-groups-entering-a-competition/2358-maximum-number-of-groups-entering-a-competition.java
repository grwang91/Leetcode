class Solution {
    public int maximumGroups(int[] grades) {
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int g: grades) {
            pq.add(g);
        }
        
        int pre = 0;
        int size = 0;
        while(pq.size() > size) {
            int cur = 0;
            int curSize = 0;
            for(int i=0; i<size+1; i++) {
                curSize++;
                cur+=pq.poll();
            }
            
            while(!pq.isEmpty() && cur <= pre) {
                curSize++;
                cur+=pq.poll();
            }
            
            if(cur <= pre) {
                break;
            }
            pre = cur;
            size = curSize;
            
            ans++;
        }
        
        return ans;
    }
}