class Solution {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        int ans = 0;
        for (int[] interval : intervals) {
            while(!pq.isEmpty() && pq.peek() <= interval[0]) {
                pq.poll();
            }
            pq.add(interval[1]);
            
            ans = Math.max(ans,pq.size());
        }
        
        
        return ans;
    }
}