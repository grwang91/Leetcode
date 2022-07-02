class Solution {
    public int minimumKeypresses(String s) {
        int[] cnt = new int[26];
        int ans = 0;
        
        for(char c: s.toCharArray()) {
            cnt[c-'a']++;
        }
        
        Arrays.sort(cnt);
        
        for(int i=25; i>=0; i--) {
            if(i>=17) {
                ans+=cnt[i];
            } else if(i>=8) {
                ans+=2*cnt[i];
            } else {
                ans+=3*cnt[i];
            }
        }
        return ans;
    }
}