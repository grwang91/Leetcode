class Solution {
    public int bestRotation(int[] nums) {
        int ans = 0;
        int max = 0;
        int n = nums.length;
        int[] score = new int[n];
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > i) {
                score[i+1]++;
                if(n-nums[i]+i+1 < n) {
                    score[n-nums[i]+i+1]--;    
                }
            } else {
                score[0]++;
                if(i-nums[i]+1 < n)
                    score[i-nums[i]+1]--;
                if(i+1 < n)
                    score[i+1]++;    
            }
        }
        
        max = score[0];
        for(int i=1; i<score.length; i++) {
            score[i]+=score[i-1];
            if(score[i] > max) {
                max = score[i];
                ans = i;
            }
        }
        return ans;
    }
}