class Solution {
    public int getMaxLen(int[] nums) {
        int max = 0;
        int s = 0;
        int e = 0;
        int neg = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                e = i-1;
                max = Math.max(max, count(nums, s, e, neg));
                neg = 0;
                s = i+1;
            } else if (nums[i] < 0) {
                neg++;
            }
        }
        // System.out.println(s+" " + neg);
        max = Math.max(max, count(nums, s, nums.length-1, neg));
        
        return max;
    }
    
    private int count(int[] nums, int s, int e, int neg) {
        if(neg%2==0) {
            return e-s+1;
        }
        
        int pre = s;
        while(pre <= e) {
            if(nums[pre] < 0) {
                break;
            }
            pre++;
        }
        
        int suf = e;
        while(suf >= s) {
            if(nums[suf] < 0) {
                break;
            }
            suf--;
        }
        
        return Math.max(e-pre, suf-s);
    }
}