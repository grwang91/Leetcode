class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int mod = 1000000007;
        long ans = 0;
        
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        long hMax = Math.max(horizontalCuts[0], h-horizontalCuts[horizontalCuts.length-1]);
        
        for(int i=1; i<horizontalCuts.length; i++) {
            hMax = Math.max(hMax, horizontalCuts[i]-horizontalCuts[i-1]);
        }
                            
        long vMax = Math.max(verticalCuts[0], w-verticalCuts[verticalCuts.length-1]);
        
        for(int i=1; i<verticalCuts.length; i++) {
            vMax = Math.max(vMax, verticalCuts[i]-verticalCuts[i-1]);
        }
        hMax%=mod;
        vMax%=mod;
        
        return (int)((vMax*hMax)%mod);
    }
}