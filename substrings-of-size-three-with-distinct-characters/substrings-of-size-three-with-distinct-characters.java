class Solution {
    public int countGoodSubstrings(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        
        int start = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
            
            if(i-start+1 < 3) continue;
            
            char sc = s.charAt(start);
            if(i-start+1 > 3) {
                map.put(sc, map.get(sc)-1);
                if(map.get(sc) == 0) {
                    map.remove(sc);
                }
                start++;
            }
            
            if(map.size()==3) {
                ans++;
            }
        }
        return ans;
    }
}