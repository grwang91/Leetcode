class Solution {
    public String largestPalindromic(String num) {
        StringBuilder sb = new StringBuilder();
        int[] cnt = new int[10];
        
        for(char c: num.toCharArray()) {
            cnt[c-'0']++;
        }
        
        boolean first = true;
        for(int i=9; i>=0; i--) {
            if(i==0 && first) break;
            
            int pair = cnt[i]/2;
            cnt[i]%=2;
            for(int j=0; j<pair; j++) {
                first = false;
                sb.append(i);
            }
        }
        int a = -1;
        for(int i=9; i>=0; i--) {
            if(cnt[i] > 0) {
                a = i;
                break;
            }
        }
        
        String rev = new StringBuilder(sb).reverse().toString();
        
        if(a != -1) {
            sb.append(a);
        }
        
        return sb.toString()+rev;
    }
}