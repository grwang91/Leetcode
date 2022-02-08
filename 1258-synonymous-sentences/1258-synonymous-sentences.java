class Solution {
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        List<String> ans = new ArrayList<>();
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        Set<String> set = new HashSet<>();
        
        for (List<String> synonym : synonyms) {
            map1.put(synonym.get(0), synonym.get(1));
            map2.put(synonym.get(1), synonym.get(0));
        }
        
        String[] splited = text.split(" ");
        backTrack(splited, 0, set, map1, map2, ans);
        
        Collections.sort(ans);
        return ans;
    }
    
    private void backTrack(String[] splited, int idx, Set<String> set, Map<String, String> map1, Map<String, String> map2, List<String> ans) {
        StringBuilder sb = new StringBuilder();
        for(String s : splited) {
            sb.append(s + " ");
        }
        String str = sb.toString().trim();
        if(set.contains(str)) {
            return;
        }
        ans.add(str);
        set.add(str);
        
        for(int i=idx; i<splited.length; i++) {
            if(map1.containsKey(splited[i])) {
                String tmp = splited[i];
                splited[i] = map1.get(splited[i]);
                backTrack(splited, i, set, map1, map2, ans);
                splited[i] = tmp;
            }
            if(map2.containsKey(splited[i])) {
                String tmp = splited[i];
                splited[i] = map2.get(splited[i]);
                backTrack(splited, i, set, map1, map2, ans);
                splited[i] = tmp;
            }
        }
    }
}