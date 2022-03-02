class Solution {
    public int minCost(String colors, int[] neededTime) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans = 0;
        pq.add(neededTime[0]);
        
        for(int i=1; i<colors.length(); i++) {
            if(colors.charAt(i) == colors.charAt(i-1)) {
                pq.add(neededTime[i]);
            } else {
                while(pq.size()>1) {
                    ans+=pq.poll();
                }
                pq.clear();
                pq.add(neededTime[i]);
            }
        }
        while(pq.size()>1) {
            ans+=pq.poll();
        }
        return ans;
    }
}