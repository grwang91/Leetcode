class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length() < k) {
            return false;
        }
        int[] cnt = new int[26];
        int odd = 0;
        
        for (char c : s.toCharArray()) {
            cnt[c-'a']++;
        }
        
        for (int num: cnt) {
            if(num%2==1) {
                odd++;
            }
        }
        
        return odd<=k;
        
    }
}