class Solution {
    public int countEven(int num) {
        int ans = 0;
        
        for(int i=1; i<=num; i++) {
            if(digitSumEven(i)) ans++;
        }
        return ans;
    }
    
    private boolean digitSumEven(int n) {
        int digitSum = 0;
        
        digitSum+=n/1000;
        n%=1000;
        digitSum+=n/100;
        n%=100;
        digitSum+=n/10;
        n%=10;
        digitSum+=n;
        
        return digitSum%2==0;
    }
}