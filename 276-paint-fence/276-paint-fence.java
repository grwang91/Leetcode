class Solution {
    public int numWays(int n, int k) { 
        int ans = 0;
        int one = k;
        int two = 0;
        
        for(int i=1; i<n; i++) {
            int nextOne = (one+two)*(k-1);
            int nextTwo = one;
            one = nextOne;
            two = nextTwo;
        }
        
        return one+two;
    }
}