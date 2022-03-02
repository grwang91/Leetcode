class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans = 0;
        int curSum = neededTime[0];
        int curMax = neededTime[0];
        for(int i=1; i<colors.length(); i++) {
            if(colors.charAt(i) == colors.charAt(i-1)) {
                curSum+=neededTime[i];
                curMax = Math.max(curMax, neededTime[i]);
            } else {
                ans+=curSum-curMax;
                curSum = neededTime[i];
                curMax = neededTime[i];
            }
        }
        ans+=curSum-curMax;
        return ans;
    }
}