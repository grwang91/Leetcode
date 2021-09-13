class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] ans = new int[nums.length];
        
        int small = 0;
        int big = 1;
        int idx = nums.length%2==0? nums.length/2-1 : nums.length/2;
        
        while (small < ans.length && idx >=0) {
            ans[small] = nums[idx--];
            small+=2;
        }
        idx = ans.length-1;
        while (big < ans.length  && idx>=0) {
            ans[big] = nums[idx--];
            big +=2;
        }
        for (int i=0; i<ans.length; i++) {
            nums[i] = ans[i];
        }
        
    }
}