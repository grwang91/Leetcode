class Solution {
    public int largestVariance(String s) {
        int[] cnt = new int[26];
        int ans = 0;
        
        for(char c: s.toCharArray()) {
            cnt[c-'a']++;
        }
        
        for(int i=0; i<26; i++) {
            for(int j=0; j<26; j++) {
                if(i==j || cnt[i]==0 || cnt[j]==0) {
                    continue;
                }
                
                int count1 = 0;
                int count2 = 0;
                int freq2 = cnt[j];
                for(int k=0; k<s.length(); k++) {
                    if(s.charAt(k)-'a'==i) {
                        count1++;
                    } else if(s.charAt(k)-'a' == j) {
                        count2++;
                        freq2--;
                    }
                    
                    if(count1 < count2 && freq2 > 0) {
                        count1 = 0;
                        count2 = 0;
                    }
                    
                    if(count1 == 0 || count2 == 0) continue;
                    ans = Math.max(ans, count1-count2);
                }
            }
        }
        return ans;
        
    }
}