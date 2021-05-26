class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] cnt = new int[26];
        
        for (char c : s1.toCharArray()) {
            cnt[c-'a']++;
        }
        
        int s = 0;
        for (int i=0; i<s2.length(); i++) {
            char c = s2.charAt(i);
            cnt[c-'a']--;
            
            if(i-s+1 > s1.length()) {
                cnt[s2.charAt(s)-'a']++;
                s++;
            }
            if(checkAllUsed(cnt)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean checkAllUsed(int[] cnt) {
        int tmp = 0;
        for (int num : cnt) {
            if(num != 0)
                return false;
        }
        
        return true;
    }
}