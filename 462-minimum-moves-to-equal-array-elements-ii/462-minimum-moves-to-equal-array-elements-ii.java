class Solution {
    public int minMoves2(int[] nums) {
        int m = nums.length/2;
        Arrays.sort(nums);
        int ans = 0;
        
        for(int i=0; i<nums.length; i++) {
            int diff = Math.abs(nums[i]-nums[m]);
            ans+=diff;
        }
        
        return ans;
    }
}