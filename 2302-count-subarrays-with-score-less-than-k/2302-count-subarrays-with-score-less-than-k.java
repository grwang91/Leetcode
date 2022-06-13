class Solution {
    public long countSubarrays(int[] nums, long k) {
        long result = 0;
        long sum =0;
        int s = 0;
        
        for(int i=0; i<nums.length; i++) {
            sum+=nums[i];
            while((i-s+1)*sum >= k) {
                sum-=nums[s++];
            }
            
            result+=(i-s+1);
        }
        return result;
    }
}