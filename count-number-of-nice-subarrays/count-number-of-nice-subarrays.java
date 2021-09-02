class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        List<Integer> odds = new ArrayList<>();
        int ans = 0;
        
        for (int i=0; i<nums.length; i++) {
            if(nums[i] % 2 == 1) {
                odds.add(i);
            }
        }
        
        
        for (int i=0; i<=odds.size()-k; i++) {
            int s = odds.get(i);
            int e = odds.get(i+k-1);
            
            int lenFront = s+1;
            int lenBack = nums.length-e;
            if(i!=0) {
                lenFront = s-odds.get(i-1);
            }
            if(i != odds.size()-k) {
                lenBack = odds.get(i+k)-e;
            }
            ans+=lenFront*lenBack;
        }
        
        return ans;
    }
}