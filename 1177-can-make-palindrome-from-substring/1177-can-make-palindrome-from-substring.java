class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int[][] counts = new int[s.length()][26];
        List<Boolean> ans = new ArrayList<>();
        
        counts[0][s.charAt(0)-'a']++;
        for (int i=1; i<s.length(); i++) {
            for (int j=0; j<26; j++) {
                counts[i][j] = counts[i-1][j];
            }
            counts[i][s.charAt(i)-'a']++;
        }
        
        for (int[] query : queries) {
            int odd = 0;
            for (int i=0; i<26; i++) {
                if(query[0] == 0) {
                    if(counts[query[1]][i] % 2 == 1) {
                        odd++;
                    }
                    continue;
                }
                if((counts[query[1]][i]-counts[query[0]-1][i]) % 2 == 1) {
                    odd++;
                }
            }

            if(odd/2<=query[2]) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }
}