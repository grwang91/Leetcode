class Solution {
    public int[] plusOne(int[] digits) {
        
        int carry = 0;
        digits[digits.length-1]++;
        for (int i=digits.length-1; i>=0; i--) {
            digits[i] = digits[i]+carry;
            carry = (digits[i])/10;
            
            digits[i] %= 10;
        }
        
        if(carry==0)
            return digits;
        
        int[] ans = new int[digits.length+1];
        for (int i=digits.length-1; i>=1; i--) {
            ans[i] = digits[i];
        }
        ans[0] = 1;
        
        return ans;
    }
}