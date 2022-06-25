class Solution {
    public int longestSubsequence(String s, int k) {
        long n = 1;
        int ones = 0;
        int zeros = 0;
        long sum = 0;
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='0') zeros++;
        }
        
        for(int i=s.length()-1; i>=0 && sum+n <=k; i--) {
            if(s.charAt(i)=='1') {
                sum+=n;
                ones++;
                // if(sum <=k) {
                //     ones++;
                // } else {
                //     break;
                // }
            }
            n<<=1;
            
        }
        
        return zeros+ones;
    }
}