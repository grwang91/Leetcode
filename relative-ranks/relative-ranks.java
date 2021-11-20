class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1,i2)-> score[i2]-score[i1]);
        String[] ans = new String[score.length];
        
        for (int i=0; i<score.length; i++) {
            pq.add(i);
        }
        
        int rank = 1;
        while(!pq.isEmpty()) {
            String r = "";
            if(rank == 1) {
                r = "Gold Medal";
            } else if(rank == 2) {
                r = "Silver Medal";
            } else if(rank == 3) {
                r = "Bronze Medal";
            } else {
                r = Integer.toString(rank);
            }
            ans[pq.poll()] = r;
            rank++;
        }
        
        return ans;
        
    }
}