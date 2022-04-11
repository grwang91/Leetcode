class Solution {
    public int minFlipsMonoIncr(String s) {
        int one = 0;
        int zero = 0;
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            int nextOne = 0;
            int nextZero = 0;
            if(c=='0') {
                nextZero = zero;
                nextOne = Math.min(zero, one)+1;
            } else {
                nextZero = zero+1;
                nextOne = Math.min(zero, one);
            }
            one = nextOne;
            zero = nextZero;
        }
        
        return Math.min(one, zero);
    }
}