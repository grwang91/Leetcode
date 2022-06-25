class Solution {
    public long maximumImportance(int n, int[][] roads) {
        Map<Integer, Integer> path = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> arr = new ArrayList<>();
        long sum = 0;
        
        for(int[] road: roads) {
            path.put(road[0], path.getOrDefault(road[0],0)+1);
            path.put(road[1], path.getOrDefault(road[1],0)+1);
        }
        
        for(int key: path.keySet()) {
            // pq.add(path.get(key));
            arr.add(path.get(key));
        }
        Collections.sort(arr);
        
        for(int i=arr.size()-1; i>=0; i--) {
            sum+=(long)(arr.get(i))*(n--);
        }
        // while(!pq.isEmpty()) {
        //     sum+=(long)pq.poll()*(n--);
        // }
        
        return sum;
    }
}