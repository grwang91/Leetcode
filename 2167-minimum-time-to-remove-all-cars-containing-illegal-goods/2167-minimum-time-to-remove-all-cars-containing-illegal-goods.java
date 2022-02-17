class Solution {
    public int minimumTime(String s) {
        int ans = Integer.MAX_VALUE;
        int ones = 0;
        int[] left = new int[s.length()];
        int[] right = new int[s.length()];

        int pre = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='0') {
                left[i] = pre;
                continue;
            } 
            left[i] = Math.min(i+1, 2+pre);
            pre = left[i];
            ones++;
        }
        
        pre = 0;
        
        for(int i=s.length()-1; i>=0; i--) {
            if(s.charAt(i)=='0') {
                right[i] = pre;
                continue;
            } 
            right[i] = Math.min(s.length()-i, 2+pre);
            pre =right[i];
        }
        
        for (int i=0; i<s.length()-1; i++) {
            ans = Math.min(left[i]+right[i+1], ans);
        }
        if(ones == s.length()) {
            return ones;
        }
        return ones==0? 0: ans;
    }
}