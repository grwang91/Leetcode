class Solution {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        pq.add(a);
        pq.add(b);
        pq.add(c);
        
        int points = 0;
        
        while(pq.size() > 1) {
            points++;
            int first = pq.poll()-1;
            int second = pq.poll()-1;
            
            if(first > 0) {
                pq.add(first);
            }
            if(second > 0) {
                pq.add(second);
            }
        }
        
        return points;
    }
}