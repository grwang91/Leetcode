class Solution {
    public int[] diStringMatch(String s) {
        int[] ans = new int[s.length()+1];
        
        int min = 0, max = s.length();
        
        for (int i=0; i<ans.length; i++) {
            if(min==max) {
                ans[i] = min;
                continue;
            }
            
            ans[i] = s.charAt(i) == 'I'? min++: max--;
        }
        
        return ans;
    }
}