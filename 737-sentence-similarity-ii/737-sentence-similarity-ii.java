class Solution {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if(sentence1.length != sentence2.length) return false;
        Map<String, Set<String>> map1 = new HashMap<>();
        
        for(List<String> pair: similarPairs) {
            if(!map1.containsKey(pair.get(0))) {
                map1.put(pair.get(0), new HashSet<>());
            }
            if(!map1.containsKey(pair.get(1))) {
                map1.put(pair.get(1), new HashSet<>());
            }
            map1.get(pair.get(0)).add(pair.get(1));
            map1.get(pair.get(1)).add(pair.get(0));
        }
        
        for(int i=0; i<sentence1.length; i++) {
            if(sentence1[i].equals(sentence2[i])) continue;
            if(map1.containsKey(sentence1[i])) {
                Set<String> seen = new HashSet<>();
                Queue<String> q = new LinkedList<>();
                boolean flag = false;
                q.add(sentence1[i]);
                seen.add(sentence1[i]);
                while(!q.isEmpty()) {
                    String cur = q.poll();
                    if(cur.equals(sentence2[i])) {
                        flag = true;
                        break;
                    }
                    for(String next: map1.get(cur)) {
                        if(!seen.contains(next)) {
                            seen.add(next);
                            q.add(next);
                        }
                    }
                }
                if(flag) {
                    continue;    
                }
                
            }
            if(!sentence1[i].equals(sentence2[i])) return false;
        }
        return true;
    }
}