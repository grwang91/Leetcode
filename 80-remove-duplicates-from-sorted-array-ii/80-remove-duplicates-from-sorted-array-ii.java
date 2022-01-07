class Solution {
    public int removeDuplicates(int[] nums) {
        int max = 10001;
        int ans = nums.length;
        
        int currentNum = -10001;
        int cnt = 0;
        for (int i=0; i<nums.length; i++) {
            if(nums[i] != currentNum) {
                cnt = 1;
                currentNum = nums[i];
                continue;
            }
            
            if(++cnt > 2) {
                nums[i] = max;
                ans--;
            }
        }
        
        Arrays.sort(nums);
        
        return ans;
    }
}