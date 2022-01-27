class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0;
        int altitude = 0;
        
        for (int g: gain) {
            altitude+=g;
            ans = Math.max(ans,altitude);
        }
        return ans;
    }
}