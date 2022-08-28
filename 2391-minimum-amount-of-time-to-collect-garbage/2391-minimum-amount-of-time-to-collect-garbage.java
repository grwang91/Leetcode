class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int ans = 0;
        int m = 0;
        int p = 0;
        int g = 0;
        for(int i=0; i<garbage.length; i++) {
            String s = garbage[i];
            ans+=s.length();
            if(s.contains("M")) {
                m = i;
            }
            if(s.contains("P")) {
                p = i;
            }
            if(s.contains("G")) {
                g = i;
            }
        }
        
        int[] prefix = new int[garbage.length];
        
        for(int i=1; i<prefix.length; i++) {
            prefix[i] = prefix[i-1] + travel[i-1];
        }
        
        ans+=prefix[m]+prefix[p]+prefix[g];
        
        return ans;
    }
}