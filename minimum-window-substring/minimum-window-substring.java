class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        int len = Integer.MAX_VALUE;
        String ans = "";
        
        for (char c : t.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int cnt = map.size();
        
        int start = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {
                continue;
            }
            map.put(c,map.get(c)-1);
            if(map.get(c)==0){
                cnt--;
            }
            
            while(cnt==0) {
                if(len > i-start+1) {
                    len = i-start+1;
                    ans = s.substring(start,i+1);
                }
                char sc = s.charAt(start);
                if(map.containsKey(sc)) {
                    map.put(sc,map.get(sc)+1);
                    if(map.get(sc) == 1) {
                        cnt++;
                    }
                }
                start++;
            }
        }
        
        return ans;
    }
    
}