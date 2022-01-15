class Solution {
    public boolean validPalindrome(String s) {
        return checkValid(s,0,s.length()-1, false);
    }
    
    private boolean checkValid(String s, int start, int end, boolean isDeleted) {
        
        while(start < end) {
            if(s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
                continue;
            }
            if(isDeleted) {
                return false;
            }
            return checkValid(s, start+1, end, true) || checkValid(s, start, end-1, true);
        }
        
        return true;
    }
}