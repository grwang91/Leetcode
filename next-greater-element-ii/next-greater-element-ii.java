class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums.length];
        
        findGreater(nums, ans, stack);
        findGreater(nums, ans, stack);
        
        return ans;
    }
    
    private void findGreater(int[] nums, int[] ans, Stack<Integer> stack) {
        
        for (int i=nums.length-1; i>=0; i--) {
            while(!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            
            stack.push(nums[i]);
        }
    }
}