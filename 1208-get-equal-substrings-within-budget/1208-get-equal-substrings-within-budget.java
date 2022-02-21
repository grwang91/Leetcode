class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int ans = 0;
        int start = 0;
        
        for(int i=0; i<s.length(); i++) {
            maxCost-=Math.abs(s.charAt(i)-t.charAt(i));
            
            while(maxCost < 0) {
                maxCost+=Math.abs(s.charAt(start)-t.charAt(start));
                start++;
            }
            ans = Math.max(ans, i-start+1);
        }
        return ans;
    }
}