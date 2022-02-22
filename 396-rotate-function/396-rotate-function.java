class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum = 0;
        int ans = 0;
        
        int rotateSum = 0;
        for(int i=0; i<nums.length; i++) {
            sum+=nums[i];
            rotateSum+=i*nums[i];
        }
        ans = rotateSum;
        
        for(int i=1; i<nums.length; i++) {
            rotateSum-=(nums.length-1)*nums[nums.length-i];
            rotateSum+=sum-nums[nums.length-i];
            ans = Math.max(rotateSum, ans);
        }
        
        return ans;
    }
}