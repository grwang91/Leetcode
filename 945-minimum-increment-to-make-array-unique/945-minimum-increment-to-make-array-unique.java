class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        
        int current = nums[0];
        for (int i=1; i<nums.length; i++) {
            if(current < nums[i]) {
                current = nums[i];
            } else {
                current++;
                ans+=current-nums[i];
            }
        }
        return ans;
    }
}