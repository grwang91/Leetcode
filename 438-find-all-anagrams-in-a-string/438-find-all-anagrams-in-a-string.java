class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] cntP = new int[26];
        int[] cntS = new int[26];
        List<Integer> ans = new ArrayList<>();
        
        for (char c: p.toCharArray()) {
            cntP[c-'a']++;
        }
        
        int start = 0;
        for (int i=0; i<s.length(); i++) {
            boolean isAnagram = true;
            cntS[s.charAt(i)-'a']++;
            while(i-start+1 > p.length()) {
                cntS[s.charAt(start++)-'a']--;
            }
            
            for (int j=0; j<26; j++) {
                if(cntP[j] != cntS[j]) {
                    isAnagram = false;
                    break;
                }
            }
            
            if(isAnagram) {
                ans.add(start);
            }
        }
        return ans;
        
    }
}