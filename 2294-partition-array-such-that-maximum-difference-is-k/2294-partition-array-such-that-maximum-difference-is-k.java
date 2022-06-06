class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        
        int min = nums[0];
        for(int i=1; i<nums.length; i++) {
            if(nums[i]-min <= k) {
                continue;
            }
            
            ans++;
            min = nums[i];
        }
        return ans+1;
    }
}