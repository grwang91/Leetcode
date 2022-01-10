class WordDistance {
    Map<String, List<Integer>> indexMap;

    public WordDistance(String[] wordsDict) {
        indexMap = new HashMap<>();
        
        for (int i=0; i<wordsDict.length; i++) {
            if(!indexMap.containsKey(wordsDict[i])) {
                indexMap.put(wordsDict[i], new ArrayList<>());
            }
            indexMap.get(wordsDict[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> word1Index = indexMap.get(word1);
        List<Integer> word2Index = indexMap.get(word2);
        
        int minDistance = Integer.MAX_VALUE;
        
        int idx1 = 0, idx2 = 0;
        while(idx1 < word1Index.size() && idx2 < word2Index.size()) {
            minDistance = Math.min(minDistance, Math.abs(word1Index.get(idx1)-word2Index.get(idx2)));
            if(word1Index.get(idx1) < word2Index.get(idx2)) {
                idx1++;
            } else {
                idx2++;
            }
        }
        
        return minDistance;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */