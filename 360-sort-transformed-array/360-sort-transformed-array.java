class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] ans = new int[nums.length];
        int s = 0;
        int e = nums.length-1;
        
        for (int i=0; i<ans.length; i++) {
            int sNum = a*nums[s]*nums[s]+b*nums[s]+c;
            int eNum = a*nums[e]*nums[e]+b*nums[e]+c;
            
            if(sNum > eNum) {
                if(a>=0) {
                    ans[ans.length-1-i] = sNum;
                    s++;
                } else {
                    ans[i] = eNum;
                    e--;
                }
            } else {
                if(a>=0) {
                    ans[ans.length-1-i] = eNum;
                    e--;
                } else {
                    ans[i] = sNum;
                    s++;
                }
            }
        }
        return ans;
    }
}