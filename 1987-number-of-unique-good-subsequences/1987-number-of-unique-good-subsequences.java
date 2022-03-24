class Solution {
    public int numberOfUniqueGoodSubsequences(String binary) {
        int ans = 0;
        int notAddedZero = 0;
        int notAddedOne = 0;
        int mod = 1000000007;
        boolean zero = false;
        
        for(char c: binary.toCharArray()) {
            if(ans==0) {
                if(c=='1') {
                    ans++;
                    notAddedZero++;
                    notAddedOne++;
                } else {
                    zero = true;
                }
                continue;
            }
            
            if(c=='1') {
                ans=(ans+notAddedOne)%mod;
                notAddedZero=(notAddedZero+notAddedOne)%mod;
            } else {
                ans = (ans+notAddedZero)%mod;
                notAddedOne=(notAddedZero+notAddedOne)%mod;
                zero = true;
            }
        }
        
        return zero?ans+1: ans;
    }
}