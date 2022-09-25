class Solution {
    public int maxCoins(int[] piles) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int p: piles) {
            pq.add(p);
        }
        
        int ans =0;
        int n = piles.length/3;
        
        for(int i=0; i<n; i++) {
            pq.poll();
            ans+=pq.poll();
        }
        
        return ans;
    }
    
}