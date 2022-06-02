class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (b1,b2) -> b2[1]-b1[1]);
        int ans = 0;
        
        for(int i=0; i<boxTypes.length; i++) {
            int loaded = Math.min(boxTypes[i][0], truckSize);
            ans+=loaded*boxTypes[i][1];
            truckSize-=loaded;
        }
        
        return ans;
    }
}