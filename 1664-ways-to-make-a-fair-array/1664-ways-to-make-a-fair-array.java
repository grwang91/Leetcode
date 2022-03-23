class Solution {
    public int waysToMakeFair(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int[] even = new int[n];
        int[] odd = new int[n];
        
        even[0] = nums[0];
        for(int i=1; i<n; i++) {
            if(i%2==0) {
                even[i] = even[i-1]+nums[i];
                odd[i] = odd[i-1];
            } else {
                even[i] = even[i-1];
                odd[i] = odd[i-1]+nums[i];
            }
        }
        
        for(int i=0; i<n; i++) {
            int curOdd = 0;
            int curEven = 0;
            if(i%2==0) {
                curOdd = odd[i]+even[n-1]-even[i];
                curEven = i==0? odd[n-1]-odd[i]: even[i-1]+odd[n-1]-odd[i];
            } else {
                curOdd = odd[i-1]+even[n-1]-even[i];
                curEven = even[i]+odd[n-1]-odd[i];
            }
            
            if(curOdd==curEven) ans++;
        }
        
        return ans;
    }
}