class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] path = new int[n];
        long sum = 0;
        
        for(int[] road: roads) {
            path[road[0]]++;
            path[road[1]]++;
        }
        
        Arrays.sort(path);
        
        for(int i=0; i<path.length; i++) {
            sum+=(long)(path[i])*(i+1);
        }
        
        return sum;
    }
}