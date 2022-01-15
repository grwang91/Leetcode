class Solution {
    public int[] findBuildings(int[] heights) {
        int maxHeight = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i=heights.length-1; i>=0; i--) {
            if(maxHeight < heights[i]) {
                maxHeight = heights[i];
                stack.push(i);
            }
        }
        
        int[] ans = new int[stack.size()];
        
        for (int i=0; i<ans.length; i++) {
            ans[i] = stack.pop();
        }
        
        return ans;
    }
}