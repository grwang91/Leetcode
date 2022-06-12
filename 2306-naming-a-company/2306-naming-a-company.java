class Solution {
    public long distinctNames(String[] ideas) {
        long ans = 0;
        
        Map<Character, List<String>> map = new HashMap<>();
        
        for(String s: ideas) {
            char c = s.charAt(0);
            if(!map.containsKey(c)) {
                map.put(c, new ArrayList<>());
            }
            map.get(c).add(s.substring(1));
        }
        
        for(int i=0; i<26; i++) {
            for(int j=i+1; j<26; j++) {
                char sc = (char)(i+'a');
                char ec = (char)(j+'a');
                
                if(!map.containsKey(sc) || !map.containsKey(ec)) {
                    continue;
                }
                
                Set<String> set = new HashSet<>();
                for(String idea: map.get(sc)) {
                    set.add(idea);
                }
                int cnt = 0;
                for(String idea: map.get(ec)) {
                    if(set.contains(idea)) {
                        set.remove(idea);
                    } else {
                        cnt++;
                    }
                }
                ans+=cnt*set.size();
            }
        }
        
        return 2*ans;
    }
}