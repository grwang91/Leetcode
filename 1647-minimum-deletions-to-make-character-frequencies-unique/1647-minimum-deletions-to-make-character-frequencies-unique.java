class Solution {
    public int minDeletions(String s) {
        Integer[] cnt = new Integer[26];
        Arrays.fill(cnt,0);
        int ans = 0;
        for(char c : s.toCharArray()) {
            cnt[c-'a']++;
        }
        
        Arrays.sort(cnt,Collections.reverseOrder());
        
        for (int i=1; i<26; i++) {
            if(cnt[i] == 0) {
                continue;
            }
            if(cnt[i-1] <= cnt[i]) {
                ans+=cnt[i]-Math.max(0,cnt[i-1]-1);
                cnt[i] = Math.max(0,cnt[i-1]-1);
            }
        }
        
        return ans;
    }
}