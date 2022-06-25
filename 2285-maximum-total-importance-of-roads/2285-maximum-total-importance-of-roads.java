class Solution {
    public long maximumImportance(int n, int[][] roads) {
        Map<Integer, Integer> path = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        
        for(int[] road: roads) {
            path.put(road[0], path.getOrDefault(road[0],0)+1);
            path.put(road[1], path.getOrDefault(road[1],0)+1);
        }
        
        for(int key: path.keySet()) {
            pq.add(path.get(key));
        }
        
        while(!pq.isEmpty()) {
            sum+=(long)pq.poll()*(n--);
        }
        
        return sum;
    }
}