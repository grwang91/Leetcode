class Solution {
    public long subArrayRanges(int[] nums) {
        long ans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i=0; i<=nums.length; i++) {
            while(stack.peek() != -1 && (i==nums.length || nums[stack.peek()] > nums[i])) {
                int pos = stack.pop();
                ans-=nums[pos]*(long)(i-pos)*(pos-stack.peek());
            }
            stack.push(i);
        }
        stack.clear();
        stack.push(-1);
        for(int i=0; i<=nums.length; i++) {
            while(stack.peek() != -1 && (i==nums.length || nums[stack.peek()] < nums[i])) {
                int pos = stack.pop();
                ans+=nums[pos]*(long)(i-pos)*(pos-stack.peek());
            }
            stack.push(i);
        }
        
        return ans;
    }
}