class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> hash = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int num : arr) {
            hash.put(num, hash.getOrDefault(num,0)+1);
        }
        
        for(int key : hash.keySet()) {
            pq.add(hash.get(key));
        }
        int cnt = 0;
        int len = 0;
        while(!pq.isEmpty()) {
            len+=pq.poll();
            cnt++;
            
            if(len >= arr.length/2) {
                return cnt;
            }
        }
        
        return 0;
        
    }
}