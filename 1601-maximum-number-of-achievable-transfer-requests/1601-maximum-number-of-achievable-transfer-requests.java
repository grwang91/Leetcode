class Solution {
    int ans;
    public int maximumRequests(int n, int[][] requests) {
        ans = 0;
        
        for (int i=0; i<(1<<requests.length); i++) {
            int bitCount = Integer.bitCount(i);
            if(bitCount <= ans) continue;
            
            int[] cnt = new int[n];
            int idx = 0;
            for(int j=i; j>0; j>>=1, idx++) {
                if((j&1) == 0) continue;
                
                cnt[requests[idx][0]]++;
                cnt[requests[idx][1]]--;
            }
            
            if(isNetZero(cnt)) {
                ans = bitCount;
            }
        }
        
        return ans;
    }
    
    private boolean isNetZero(int[] cnts) {
        for (int count: cnts) {
            if(count != 0) {
                return false;
            }
        }
        return true;
    }
}