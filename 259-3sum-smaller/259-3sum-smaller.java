class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int ans = 0;
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length; i++) {
            int curTarget = target-nums[i];
            int s = i+1;
            int e = nums.length-1;
            
            while(s<e) {
                if(nums[s]+nums[e] < curTarget) {
                    ans+=e-s;
                    s++;
                } else {
                    e--;
                }
            }
        }
        
        return ans;
    }
}