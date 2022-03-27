class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int ans = 0;
        String s = Integer.toString(n);
        int pow = s.length()-1;
        int[] dp = new int[pow+1];
        
        int cur = 1;
        dp[0] = 1;
        for(int i=1; i<=pow; i++) {
            cur*=digits.length;
            ans+=cur;
            dp[i] = cur;
        }
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            boolean flag = false;
            for(int j=0; j<digits.length; j++) {
                char dc = digits[j].charAt(0);
                if(dc < c) {
                    ans+=dp[dp.length-1-i];
                } else if(dc == c) {
                    if(i==s.length()-1) ans++;
                    flag = true;
                    break;
                } else {
                    return ans;
                }
            }
            if(!flag) return ans;
        }
        
        return ans;
    }
}