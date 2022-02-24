class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1,n2)-> n2.prob>n1.prob? 1: -1);
        Map<Integer, Map<Integer, Double>> map = new HashMap<>();
        
        for(int i=0; i<edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            
            if(!map.containsKey(from)) {
                map.put(from, new HashMap<>());
            }
            if(!map.containsKey(to)) {
                map.put(to, new HashMap<>());
            }
            map.get(from).put(to, succProb[i]);
            map.get(to).put(from, succProb[i]);
        }
        
        boolean[] check = new boolean[n];
        pq.add(new Node(start, 1d));
        
        while(!pq.isEmpty()) {
            Node current = pq.poll();
            if(current.num == end) {
                return current.prob;
            }
            check[current.num] = true;
            
            if(!map.containsKey(current.num)) continue;
            
            for(int num: map.get(current.num).keySet()) {
                if(!check[num]) {
                    pq.add(new Node(num, current.prob*map.get(current.num).get(num)));
                }
            }
            
        }
        
        return 0;
    }
    
    class Node {
        double prob;
        int num;
        
        public Node(int num, double prob) {
            this.num = num;
            this.prob = prob;
        }
    }
}