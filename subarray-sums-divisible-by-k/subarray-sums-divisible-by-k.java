class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        
        map.put(0,1);
        
        for (int i=0; i<nums.length; i++) {
            sum = (sum+nums[i])%k < 0 ? (sum+nums[i])%k + k : (sum+nums[i])%k;

            if(map.containsKey(sum)) {
                ans+=map.get(sum);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}