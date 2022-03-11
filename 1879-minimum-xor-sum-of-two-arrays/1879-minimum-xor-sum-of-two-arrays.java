class Solution {
    public int dfs(int bitmask,int n,int[] mem,int[] n1,int[] n2) {
        if (mem[bitmask] >= 0) return mem[bitmask];
        int len = n1.length;
        int bit = 1<<(len-1);
        int ans = Integer.MAX_VALUE;
        int ind = 0;
        if (n==(n1.length-1)) {
            while ((bitmask & bit)==0) {
                bit = bit>>1;
                ind++;
            }
            mem[bitmask] = n1[ind] ^ n2[len-1];
            return mem[bitmask];
        }
        while (bit > 0) {
            if ((bit & bitmask) > 0) {
                ans = Math.min(ans,(n1[ind]^n2[n]) + dfs(bitmask & (~bit),n+1,mem,n1,n2));
            }
            bit = bit>>1;
            ind++;
        }
        mem[bitmask] = ans;
        return mem[bitmask];
    }
    public int minimumXORSum(int[] nums1, int[] nums2) {
        int[] mem = new int[(int)Math.pow(2,nums1.length)];
        Arrays.fill(mem,-1);
        return dfs((int)Math.pow(2,nums1.length)-1,0,mem,nums1,nums2);
    }
}