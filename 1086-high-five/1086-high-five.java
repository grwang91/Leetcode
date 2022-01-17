class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        
        for (int[] item : items) {
            map.computeIfAbsent(item[0], k -> new PriorityQueue<>()).add(item[1]);
            if(map.get(item[0]).size() > 5) {
                map.get(item[0]).poll();
            }
        }
        
        int[][] ans = new int[map.size()][2];
        
        int idx = 0;
        for (int key : map.keySet()) {
            int average = avg(map.get(key));
            ans[idx][0] = key;
            ans[idx++][1] = average;
        }
        
        return ans;
    }
    
    private int avg(PriorityQueue<Integer> pq) {
        int out = 0;
        while(!pq.isEmpty()) {
            out+=pq.poll();
        }
        return out/5;
    }
}