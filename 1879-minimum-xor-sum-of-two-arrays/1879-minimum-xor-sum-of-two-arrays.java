class Solution {
    int[][] memo;
    public int minimumXORSum(int[] nums1, int[] nums2) {
        memo = new int[nums1.length][(1<<nums1.length)];
        for(int i=0; i<memo.length; i++) {
            Arrays.fill(memo[i], -1);    
        }
        
        return calc(nums1, nums2, 0, 0);
    }
    
    private int calc(int[] nums1, int[] nums2, int idx, int mask) {
        if(idx == nums1.length) return 0;
        
        if(memo[idx][mask] != -1) return memo[idx][mask];
        
        int min = Integer.MAX_VALUE;
        for(int i=0; i<nums2.length; i++) {
            if((mask&(1<<i)) == 0) {
                int sum = (nums1[idx]^nums2[i]) + calc(nums1, nums2, idx+1, mask|(1<<i));
                min = Math.min(sum, min);
            }
        }
        
        memo[idx][mask] = min;
        return min;
    }
}