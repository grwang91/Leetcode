class Solution {
    public int minAddToMakeValid(String s) {
        int minus = 0;
        int count = 0;
        int ans = 0;
        for (char c : s.toCharArray()) {
            if(c=='(') {
                count++;
            } else {
                count--;
            }
            
            if(count < 0) {
                minus = Math.min(count,minus);
            }
        }
        
        count-=minus;
        
        return count-minus;
    }
}