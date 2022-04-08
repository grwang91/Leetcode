class Solution {
    public int minSteps(String s, String t) {
        int[] cnt = new int[26];
        int ans = 0;
        
        for(char c: s.toCharArray()) {
            cnt[c-'a']++;
        }
        for(char c: t.toCharArray()) {
            cnt[c-'a']--;
        }
        
        for(int i=0; i<26; i++) {
            ans+=Math.abs(cnt[i]);
        }
        return ans;
    }
}