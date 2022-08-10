class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] check = new boolean[n+1];
        check[0] = true;
        
        for(int i=1; i<nums.length; i++) {
            if(i > 1) {
                if((nums[i] == nums[i-1] && nums[i-1] == nums[i-2]) || nums[i]-nums[i-1] == 1 && nums[i-1]-nums[i-2]==1) {
                    check[i+1] |= check[i-2];
                }
            }
            
            if(nums[i] == nums[i-1]) {
                check[i+1] |= check[i-1];
            }
        }
        
        return check[n];
    }
}