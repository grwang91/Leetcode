class Solution {
    public int longestSubstring(String s, int k) {
        int[] cnt = new int[26];
        int freq = 0;
        int ans = 0;
        
        for(char c: s.toCharArray()) {
            cnt[c-'a']++;
            if(cnt[c-'a']==1) freq++;
        }
        
        for(int i=1; i<=freq; i++) {
            int start = 0;
            int chars = 0;
            cnt = new int[26];
            for(int j=0; j<s.length(); j++) {
                char c = s.charAt(j);
                cnt[c-'a']++;
                if(cnt[c-'a']==1) {
                    chars++;
                }
                while(chars > i) {
                    char sc = s.charAt(start++);
                    cnt[sc-'a']--;
                    if(cnt[sc-'a']==0) {
                        chars--;
                    }
                }
                
                boolean flag = true;
                for(int num: cnt) {
                    if(num == 0) continue;
                    if(num < k) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    ans = Math.max(ans, j-start+1);
                }
            }
        }
        return ans;
    }
}