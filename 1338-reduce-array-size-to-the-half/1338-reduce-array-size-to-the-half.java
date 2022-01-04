class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> hash = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int num : arr) {
            hash.put(num, hash.getOrDefault(num,0)+1);
        }
        int len = 0;
        for(int key : hash.keySet()) {
            len+=hash.get(key);
            pq.add(hash.get(key));
            
            while(!pq.isEmpty()) {
                if(len-pq.peek() >= arr.length/2) {
                    len-=pq.poll();
                } else {
                    break;
                }
            }
        }
//         int cnt = 0;
        
//         while(!pq.isEmpty()) {
//             len+=pq.poll();
//             cnt++;
            
//             if(len >= arr.length/2) {
//                 return cnt;
//             }
//         }
        
        return pq.size();
        
    }
}