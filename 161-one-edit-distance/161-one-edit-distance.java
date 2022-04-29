class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(Math.abs(s.length()-t.length()) > 1) return false;
        
        if(s.length() < t.length()) {
            return isOneEditDistance(t, s);
        }
        
        for(int i=0; i<t.length(); i++) {
            if(s.charAt(i)==t.charAt(i)) {
                continue;
            }
            
            if(s.length() == t.length()) {
                return s.substring(i+1).equals(t.substring(i+1));
            } else {
                return s.substring(i+1).equals(t.substring(i));
            }
        }
        
        return s.length()!=t.length();
    }
}