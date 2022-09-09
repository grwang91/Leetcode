class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (p1,p2)->p1[0]==p2[0]? p2[1]-p1[1]: p1[0]-p2[0]);
        int n = properties.length;
        int ans = 0;
        int maxDef = 0;
        
        for(int i=n-1; i>=0; i--) {
            if(properties[i][1] < maxDef) {
                ans++;
            }
            maxDef = Math.max(maxDef, properties[i][1]);
        }
        return ans;
    }
}