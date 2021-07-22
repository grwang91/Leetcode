class Solution {
    public int partitionDisjoint(int[] nums) {
        int maxIdx = 0;
        int maxNum = nums[0];
        int maxSoFar = nums[0];
        
        for (int i=1; i<nums.length; i++) {
            if(nums[i] >= maxNum)  {
                maxSoFar = Math.max(nums[i],maxSoFar);
                continue;
            }
            
            maxIdx = i;
            maxNum = maxSoFar;
            
        }
        
        return maxIdx+1;
        
    }
    
}