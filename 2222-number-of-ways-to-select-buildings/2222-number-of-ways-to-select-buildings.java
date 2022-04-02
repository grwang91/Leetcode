class Solution {
    public long numberOfWays(String s) {
        long ans = 0;
        long ones = 0;
        long zeros = 0;
        for(char c: s.toCharArray()) {
            if(c=='0') {
                zeros++;
            } else {
                ones++;
            }
        }
        
        long currentOnes = 0;
        long currentZeros = 0;
        for(char c: s.toCharArray()) {
            if(c=='0') {
                ans+=currentOnes*(ones-currentOnes);
                currentZeros++;
            } else {
                ans+=currentZeros*(zeros-currentZeros);
                currentOnes++;
            }
        }
        
        return ans;
    }
}