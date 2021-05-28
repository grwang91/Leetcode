class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int start = 0;
        int[] cnt = new int[100001];
        int ans = 0;
        int sum = 0;
        
        for (int i=0; i<nums.length; i++) {
            cnt[nums[i]]++;
            sum+=nums[i];
            while(cnt[nums[i]] > 1) {
                cnt[nums[start]]--;
                sum-=nums[start++];
            }
            ans = Math.max(ans,sum);
        }
        return ans;
    }
}