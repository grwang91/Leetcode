class Solution {
    public int maxSumAfterOperation(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        left[0] = Math.max(0,nums[0]);
        for(int i=1; i<n; i++) {
            left[i] = Math.max(0, left[i-1]+nums[i]);
        }
        
        right[n-1] = Math.max(0,nums[n-1]);
        for(int i=n-2; i>=0; i--) {
            right[i] = Math.max(0, right[i+1]+nums[i]);
        }
        
        for(int i=0; i<n; i++) {
            int sum = nums[i]*nums[i];
            if(i>0) {
                sum+=left[i-1];
            }
            if(i<n-1) {
                sum+=right[i+1];
            }
            ans = Math.max(ans,sum);
        }
        return ans;
    }
}