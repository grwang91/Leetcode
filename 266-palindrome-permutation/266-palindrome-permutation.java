class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] counts = new int[26];
        int odd = 0;
        
        for (char c : s.toCharArray()) {
            counts[c-'a']++;
        }
        
        for (int cnt : counts) {
            if(cnt%2==1) {
                odd++;
            }
        }
        
        return odd<=1;
    }
}