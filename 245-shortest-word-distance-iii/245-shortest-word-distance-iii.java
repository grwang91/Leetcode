class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        List<Integer> idx1 = new ArrayList<>();
        List<Integer> idx2 = new ArrayList<>();
        
        for(int i=0; i<wordsDict.length; i++) {
            String s = wordsDict[i];
            if(s.equals(word1)) {
                idx1.add(i);
            }
            if(s.equals(word2)) {
                idx2.add(i);
            }
        }
        
        int min = wordsDict.length;
        if(word1.equals(word2)) {
            for(int i=1; i<idx1.size(); i++) {
                min = Math.min(min, idx1.get(i)-idx1.get(i-1));
            }
            return min;
        }
        
        int i1 = 0;
        int i2 = 0;
        
        while(i1<idx1.size() && i2<idx2.size()) {
            int cur1 = idx1.get(i1);
            int cur2 = idx2.get(i2);
            
            min = Math.min(min, Math.abs(cur1-cur2));
            
            if(cur1 <= cur2) {
                i1++;
            } else {
                i2++;
            }
        }
        return min;
    }
}