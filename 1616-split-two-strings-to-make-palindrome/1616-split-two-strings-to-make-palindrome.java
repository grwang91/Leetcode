class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        return checkSplitPalindrome(a, b) || checkSplitPalindrome(b, a);
    }
    
    private boolean checkSplitPalindrome(String a, String b) {
        int idx = (a.length()+1)/2;
        
        while(idx < a.length()) {
            if(a.charAt(idx) != a.charAt(a.length()-1-idx)) {
                break;
            }
            idx++;
        }
        int idx2 = idx;
        while(idx < a.length()) {
            if(a.charAt(idx) != b.charAt(a.length()-1-idx)) {
                break;
            }
            idx++;
        }
        if(idx == a.length()) {
            return true;
        }
        
        while(idx2 < a.length()) {
            if(b.charAt(idx2) != a.charAt(a.length()-1-idx2)) {
                return false;
            }
            idx2++;
        }
        
        
        return true;
    }
}