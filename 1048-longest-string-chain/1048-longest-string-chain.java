class Solution {
    public int longestStrChain(String[] words) {
        int ans = 0;
        Map<String, Integer> map = new HashMap<>();
        Arrays.sort(words, (w1, w2)-> w1.length()-w2.length());
        
        for(int i=0; i<words.length; i++) {
            String word = words[i];
            int curLen = 0;
            for(int j=0; j<word.length(); j++) {
                StringBuilder sb = new StringBuilder(word);
                sb.deleteCharAt(j);
                String deleted = sb.toString();
                int len = map.getOrDefault(deleted, 0)+1;
                curLen = Math.max(len, curLen);
            }
            
            map.put(word, curLen);
            ans = Math.max(ans, curLen);
        }
        
        return ans;
    }
}