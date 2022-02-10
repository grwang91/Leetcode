class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        
        int start = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
            
            while(map.size()>k) {
                char sc = s.charAt(start);
                int freq = map.get(sc);
                if(freq==1) {
                    map.remove(sc);
                } else {
                    map.put(sc, freq-1);
                }
                start++;
            }
            
            maxLength = Math.max(maxLength, i-start+1);
        }
        
        return maxLength;
    }
}