class Solution {
    public int pivotIndex(int[] nums) {
        int right = 0;
        int left = 0;
        
        for (int i=0; i<nums.length; i++) {
            right+=nums[i];
        }
        
        for (int i=0; i<nums.length; i++) {
            int pivot = nums[i];
            right-=pivot;
            if(left == right) {
                return i;
            }
            
            left+=pivot;
        }
        
        return -1;
    }
}