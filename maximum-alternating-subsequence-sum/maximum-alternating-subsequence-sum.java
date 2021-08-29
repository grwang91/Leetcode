class Solution {
    public long maxAlternatingSum(int[] nums) {

        long odd= nums[0], even=0;
        for(int i=1; i<nums.length; i++)
        {
            long o= Math.max(odd,even+ nums[i]);
            long e= Math.max(even,odd- nums[i]);
            odd=o; even=e;
        }
        return Math.max(odd,even);
    }
}