class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        int n = queries.length;
        long[] ans = new long[queries.length];
        
        int cntPre = intLength/2;
        int cntMid = intLength%2;
        int max = 1;
        if(cntPre > 0) {
            max*=9;   
        }
        for(int j=1; j<cntPre; j++) {
            max*=10;
        }
        if(cntMid == 1) {
            max*=10;
        }
        System.out.println(max);
        if(intLength%2==0) {
            findEven(queries, intLength, max, ans);
        } else {
            findOdd(queries, intLength, max, ans);
        }
        return ans;
    }
    
    private void findOdd(int[] queries, int intLength, int max, long[] ans) {
        for(int i=0; i<queries.length; i++) {
            int num  = queries[i];
            if(num > max) {
                ans[i] = -1;
                continue;
            }
            
            int base = (int)Math.pow(10,intLength/2);
            
            StringBuilder sb = new StringBuilder();
            sb.append(base+num-1);
            String cur = sb.toString();
            sb.setLength(sb.length()-1);
            cur+=sb.reverse().toString();
            ans[i] = cur.length() == intLength? Long.parseLong(cur): -1;
        }
    }
    
    private void findEven(int[] queries, int intLength, int max, long[] ans) {
        
        for(int i=0; i<queries.length; i++) {
            int num  = queries[i];
            if(num > max) {
                ans[i] = -1;
                continue;
            }
            
            int base = (int)Math.pow(10,intLength/2-1);
            
            StringBuilder sb = new StringBuilder();
            sb.append(base+num-1);
            
            ans[i] = Long.parseLong(sb.toString()+sb.reverse().toString());
        }
    }
}