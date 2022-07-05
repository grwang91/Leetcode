class Solution {
    public int minInsertions(String s) {
        int val = 0;
        int ans = 0;
        
        for(char c: s.toCharArray()) {
            if(c=='(') {
                if(val%2 != 0) {
                    ans++;
                    val--;
                }
                val+=2;
            } else {
                val--;
            }
            
            if(val < 0) {
                ans++;
                val+=2;
            }
        }

        return ans+val;
    }
}