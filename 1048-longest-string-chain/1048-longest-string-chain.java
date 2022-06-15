class Solution {
    public int longestStrChain(String[] words) {
        int ans = 1;
        int[] len = new int[words.length];
        Arrays.fill(len, 1);
        Arrays.sort(words, (w1, w2)-> w1.length()-w2.length());
        
        for(int i=0; i<words.length; i++) {
            for(int j=i+1; j<words.length; j++) {
                if(predecessor(words[i], words[j])) {
                    len[j] = Math.max(len[j], len[i]+1);
                    ans = Math.max(ans, len[j]);
                }
            }
        }
        
        return ans;
    }
    
    private boolean predecessor(String a, String b) {
        if(b.length()-a.length() != 1) return false;
        
        char added = ' ';
        int[] cnt = new int[26];
        
        for(char c: a.toCharArray()) {
            cnt[c-'a']++;
        }
        for(char c: b.toCharArray()) {
            cnt[c-'a']--;
            if(cnt[c-'a'] < 0) {
                added = c;
            }
        }
        
        for(int i=0; i<=a.length(); i++) {
            if((a.substring(0,i)+added+a.substring(i)).equals(b)) return true;
        }
        
        return false;
    }
}