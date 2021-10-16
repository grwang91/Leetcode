class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for(String word: wordList) {
            dict.add(word);
        }
        
        if(!dict.contains(endWord)) {
            return 0;
        }
        
        //BFS
        Queue<String> q = new LinkedList<String>();
        q.offer(beginWord);
        int level = 1;
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                String currWord = q.poll();
                
                if(currWord.equals(endWord)) {
                    return level;
                }
                
                char[] chArr = currWord.toCharArray();
                for(int j = 0; j < chArr.length; j++) {
                    char ch = chArr[j];
                    for(char k = 'a'; k <= 'z'; k++) {
                        if(chArr[j] == k) {
                            continue;
                        }
                        chArr[j] = k;
                        String newWord = String.valueOf(chArr);
                        
                        if(dict.contains(newWord)) {
                            q.offer(newWord);
                            dict.remove(newWord);
                        }
                    }
                    chArr[j] = ch;
                }
            }
            level++;
        }
        
        return 0;
    }
}