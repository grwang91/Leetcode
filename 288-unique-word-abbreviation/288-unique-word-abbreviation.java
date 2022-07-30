class ValidWordAbbr {
    Map<String, Integer> map;
    Set<String> set;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        set = new HashSet<>();
        
        for(String s: dictionary) {
            String abb = abbre(s);
            if(!set.contains(s)) {
                map.put(abb, map.getOrDefault(abb,0)+1);
            }
            set.add(s);
        }
    }
    
    public boolean isUnique(String word) {
        if(set.contains(word) && map.get(abbre(word)) == 1) return true;
        
        return !map.containsKey(abbre(word));
    }
    
    private String abbre(String s) {
        int len = s.length()-2;
        
        return len > 0? s.charAt(0)+Integer.toString(len)+s.charAt(s.length()-1): s;
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */