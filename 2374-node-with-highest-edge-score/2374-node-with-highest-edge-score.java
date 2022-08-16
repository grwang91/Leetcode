class Solution {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long max = 0;
        int maxIndex = 0;
        long[] scores = new long[n];
        for (int i = 0; i < edges.length; i++) {
            scores[edges[i]] += i;
            if (max < scores[edges[i]]) {
                max = scores[edges[i]];
                maxIndex = edges[i];
            } else if (max == scores[edges[i]]) {
                maxIndex = Math.min(maxIndex, edges[i]);
            }
        }
        return maxIndex;
    }
}