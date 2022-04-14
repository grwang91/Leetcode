class Solution {
    public int minSwaps(int[] data) {
        int[] prefixSum = new int[data.length+1];
        int max = 0;
        
        for(int i=1; i<prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i-1]+data[i-1];
        }
        int ones = prefixSum[prefixSum.length-1];
        
        for(int i=ones; i<prefixSum.length; i++) {
            max = Math.max(max, prefixSum[i]-prefixSum[i-ones]);
        }
        
        return ones-max;
    }
}