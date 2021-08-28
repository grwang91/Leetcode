class Solution {
    public long maxAlternatingSum(int[] nums) {
        
        long evenSum = 0;
        long oddSum = nums[0];
        
        for (int i=1; i<nums.length; i++) {
            long tmpEven = oddSum - nums[i];
            long tmpOdd = evenSum + nums[i];
            
            evenSum = Math.max(evenSum, tmpEven);
            oddSum = Math.max(oddSum, tmpOdd);
        }
        
        return oddSum;
    }
}