class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> hash = new HashMap<>();
        int[] ans = new int[nums1.length];
        
        for (int i=nums2.length-1; i>=0; i--) {
            while(!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                hash.put(nums2[i],-1);
            } else {
                hash.put(nums2[i],stack.peek());
            }
            stack.push(nums2[i]);
        }
        
        for (int i=0; i<ans.length; i++) {
            ans[i] = hash.get(nums1[i]);
        }
        return ans;
    }
}