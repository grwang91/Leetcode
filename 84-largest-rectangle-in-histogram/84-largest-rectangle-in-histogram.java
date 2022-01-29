class Solution {
    public int largestRectangleArea(int[] heights) {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n2.val-n1.val);
        int ans = 0;
        
        for (int i=0; i<heights.length; i++) {
            int idx = i;
            while(!pq.isEmpty() && pq.peek().val >= heights[i]) {
                Node current = pq.poll();
                ans = Math.max(ans, current.val*(i-current.idx));
                idx = Math.min(idx, current.idx);
            }
            pq.add(new Node(heights[i],idx));
        }
        
        while(!pq.isEmpty()) {
            Node current = pq.poll();
            ans = Math.max(ans, current.val*(heights.length-current.idx));
        }
        
        return ans;
    }
    
    class Node {
        int val, idx;
        
        public Node (int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
}