class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int ans = 0;
        
        for (int i=0; i<heights.length; i++) {
            
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                
                int popped = stack.pop();
                ans = Math.max(ans,heights[popped]*(i-stack.peek()-1));
            }
            stack.push(i);
        }
        
        while(stack.peek() != -1) {
            int popped = stack.pop();
            ans = Math.max(ans,heights[popped]*(heights.length-stack.peek()-1));

        }
        
        return ans;
    }

}