class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        int[] sum1 = calcSum(Arrays.copyOfRange(nums, 0, nums.length/2));
        int[] sum2 = calcSum(Arrays.copyOfRange(nums, nums.length/2, nums.length));
        
        Arrays.sort(sum1);
        Arrays.sort(sum2);
        
        int diff = Integer.MAX_VALUE;
        int idx1 = 0;
        int idx2 = sum2.length-1;
        while(idx1 < sum1.length && idx2>=0) {
            int curSum = sum1[idx1]+sum2[idx2];
            int curDiff = Math.abs(curSum-goal);
            diff = Math.min(diff, curDiff);
            
            if(curSum > goal) {
                idx2--;
            } else {
                idx1++;
            }
        }
        
        return diff;
    }
    
    private int[] calcSum(int[] nums) {
        int[] sum = new int[(1<<nums.length)];
        
        for(int i=0; i<sum.length; i++) {
            int mask = 1;
            int idx = 0;
            int curSum = 0;
            while(mask > 0) {
                if((mask&i) != 0) {
                    curSum+=nums[idx];
                }
                idx++;
                mask = mask<<1;
            }
            sum[i] = curSum;
        }
        return sum;
    }

}