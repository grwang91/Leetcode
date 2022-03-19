class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int start = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
            while(map.size() > 2) {
                char cs = s.charAt(start);
                if(map.get(cs)==1) {
                    map.remove(cs);
                } else {
                    map.put(cs,map.get(cs)-1);
                }
                start++;
            }
            ans = Math.max(ans, i-start+1);
        }
        return ans;
    }
}