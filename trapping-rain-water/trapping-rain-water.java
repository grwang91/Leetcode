class Solution {
    public int trap(int[] height) {
        int[] left2right = new int[height.length];
        int[] right2left = new int[height.length];
        int ans = 0;
        
        int max = 0;
        for (int i=0; i<height.length; i++) {
            max = Math.max(max,height[i]);
            left2right[i] = Math.max(max-height[i], 0);
        }
        max = 0;
        for (int i=height.length-1; i>=0; i--) {
            max = Math.max(max,height[i]);
            right2left[i] = Math.max(max-height[i], 0);
        }
        
        for (int i=0; i<height.length; i++) {
            ans+=Math.min(left2right[i], right2left[i]);
        }
        return ans;
    }
}