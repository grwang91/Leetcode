class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        PriorityQueue<Work> pq = new PriorityQueue<>((w1, w2) -> w2.profit - w1.profit);
        int ans = 0;
        Arrays.sort(worker);
        for (int i=0; i<profit.length; i++) {
            pq.add(new Work(profit[i], difficulty[i]));
        }
        
        for (int i=worker.length-1; i>=0; i--) {
            
            while(!pq.isEmpty() && pq.peek().difficulty > worker[i]) {
                pq.poll();
            }
            
            ans+=pq.isEmpty()? 0: pq.peek().profit;
        }
        
        return ans;
    }
    
    class Work {
        int profit, difficulty;
        
        public Work(int profit, int difficulty) {
            this.profit = profit;
            this.difficulty = difficulty;
        }
    }
}