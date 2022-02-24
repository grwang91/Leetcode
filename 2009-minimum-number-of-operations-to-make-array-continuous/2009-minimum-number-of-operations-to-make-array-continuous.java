class Solution {
    public int minOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            if(set.contains(nums[i])) {
                nums[i] = Integer.MAX_VALUE;
            } else {
                set.add(nums[i]);
            }
        }
        Arrays.sort(nums);
        int ans = nums.length;
        
        int e = nums.length-1;
        for(int i=0; i<nums.length; i++) {
            int max = nums[i]+nums.length-1;
            if(e >= nums.length || e>=0 && nums[e] > max) {
                while(e>= nums.length || e>=0 && nums[e] > max) {
                    e--;
                }
                ans=Math.min(ans, nums.length-(e-i+1));
            } else {
                while(e<nums.length && e>=0 && nums[e] <= max) {
                    e++;
                }
                ans= Math.min(ans, nums.length-(e-i));
            }
        }
//         for(int i=0; i<nums.length; i++) {
//             int op = i;
//             int max = nums[i]+nums.length-1;
            
//             int s = i;
//             int e = nums.length;
//             while(s<e) {
//                 int m = (s+e)/2;
//                 if(nums[m] <= max) {
//                     s = m+1;
//                 } else {
//                     e = m;
//                 }
//             }
//             op+=nums.length-(e);
//             ans = Math.min(ans,op);
//         }
        return ans;
    }
}