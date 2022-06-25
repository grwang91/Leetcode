class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int pre = 0;
        int ans = 0;
        
        for(int value: values) {
            pre--;
            ans = Math.max(ans, value+pre);
            
            if(value > pre) {
                pre = value;
            }
        }
        return ans;
    }
}