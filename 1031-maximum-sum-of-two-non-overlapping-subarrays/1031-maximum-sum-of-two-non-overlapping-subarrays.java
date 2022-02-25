class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int[] prefix = new int[nums.length+1];
        int ans = 0;
        
        for(int i=1; i<=nums.length; i++) {
            prefix[i]=prefix[i-1]+nums[i-1];
        }
        
        int leftMaxSum = 0;
        for(int i=firstLen; i<=nums.length-secondLen; i++) {
            int val = prefix[i]-prefix[i-firstLen];
            leftMaxSum = Math.max(leftMaxSum, val);
            ans = Math.max(ans, leftMaxSum+prefix[i+secondLen]-prefix[i]);
        }
        
        int rightMaxSum = 0;
        for(int i=secondLen; i<=nums.length-firstLen; i++) {
            int val = prefix[i]-prefix[i-secondLen];
            rightMaxSum = Math.max(rightMaxSum, val);
            ans = Math.max(ans, rightMaxSum+prefix[i+firstLen]-prefix[i]);
        }
        
        return ans;
    }
}