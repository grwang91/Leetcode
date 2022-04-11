class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int mod = 1000000007;
        long ans = 1;
        for(int num: nums) {
            pq.add(num);
        }
        
        for(int i=0; i<k; i++) {
            int cur = pq.poll();
            pq.add(cur+1);
        }
        
        while(!pq.isEmpty()) {
            ans = (ans*pq.poll())%mod;
        }
        return (int)ans;
    }
}