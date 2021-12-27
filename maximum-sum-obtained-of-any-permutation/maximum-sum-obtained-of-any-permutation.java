class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int mod = 1000000007;
        long ans = 0;
        
        Arrays.sort(nums);
        int[] cnt = new int[nums.length];
        
        for (int i=0; i<requests.length; i++) {
            int s = requests[i][0];
            int e = requests[i][1]+1;
            
            cnt[s]++;
            if(e<nums.length)
                cnt[e]--;   
        }

        for (int i=1; i<cnt.length; i++) {
            cnt[i]+=cnt[i-1];
        }

        Arrays.sort(cnt);
        
        for (int i=0; i<cnt.length; i++) {
            long x = cnt[i]%mod;
            long y = nums[i]%mod;
            ans+=x*y;
        }
        
        return (int)(ans%mod);
    }
    
    private int product(int[] nums, int[] cnt, int idx, int mod) {
        int result = 0;

        for(int i=0; i<cnt[idx]; i++) {
            result = (result+nums[idx])%mod;
        }

        return result;
    }
}