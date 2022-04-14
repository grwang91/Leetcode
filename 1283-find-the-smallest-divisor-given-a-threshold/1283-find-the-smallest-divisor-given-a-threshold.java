class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int ans = Integer.MAX_VALUE;
        
        int s = 1;
        int e = 1000001;
        
        while(s<e) {
            int m = (s+e)/2;
            
            int sum = getSum(nums, m);
            if(sum <= threshold) {
                ans = Math.min(ans, m);
                e = m;
            } else {
                s = m+1;
            }
        }
        return ans;
    }
    
    private int getSum(int[] nums, int m) {
        int out = 0;
        for(int num: nums) {
            out+=(num-1)/m+1;
        }
        return out;
    }
}