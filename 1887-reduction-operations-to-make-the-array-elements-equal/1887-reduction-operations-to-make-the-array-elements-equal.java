class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        
        int ans = 0;
        int order = 0;
        int start = 0;
        
        for (int i=0; i<nums.length-1; i++) {
            if(nums[i] == nums[i+1]) {
                continue;
            }
            
            ans+=(i-start+1)*order;
            order++;
            start = i+1;
        }
        
        return ans+(nums.length-start)*order;
    }
}