class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans = 0;
        for(int n: sticks) {
            pq.add(n);
        }
        
        while(pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            ans+=a+b;
            pq.add(a+b);
        }
        return ans;
    }
}