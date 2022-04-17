class Solution {
    public int minimumDeletions(String s) {
        int ans = Integer.MAX_VALUE;
        int numA = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='a') {
                numA++;
            }
        }
        
        int numB = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='a') {
                numA--;
            } else {
                ans = Math.min(ans, numA+numB);
                numB++;
            }
        }
        return Math.min(ans, numB);
    }
}