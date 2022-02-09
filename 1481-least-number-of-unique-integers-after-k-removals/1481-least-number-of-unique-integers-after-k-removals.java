class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((n1,n2)->n1.freq-n2.freq);
        for (int num : arr) {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        
        for(int key : map.keySet()) {
            pq.add(new Node(key, map.get(key)));
        }
        
        while(k>0) {
            if(pq.peek().freq <= k) {
                k-=pq.peek().freq;
                pq.poll();
            } else {
                break;
            }
        }
        
        return pq.size();
    }
    
    class Node {
        int num, freq;
        
        public Node(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }
}