class Solution {
    public String maxValue(String n, int x) {
        char c = (char)(x+'0');
        String ans = "";
        if(n.charAt(0) == '-') {
            int idx = -1;
            
            for (int i=1; i<n.length(); i++) {
                if(c < n.charAt(i)) {
                    idx = i;
                    break;
                }
            }
            ans = idx == -1 ? n+c : n.substring(0,idx)+c+n.substring(idx);
        } else {
            int idx = -1;
            
            for (int i=0; i<n.length(); i++) {
                if(c > n.charAt(i)) {
                    idx = i;
                    break;
                }
            }
            ans = idx == -1 ? n+c : n.substring(0,idx)+c+n.substring(idx);
        }
        return ans;
    }
}