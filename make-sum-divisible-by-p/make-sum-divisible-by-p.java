class Solution {
    public int minSubarray(int[] nums, int p) {
        int sum = 0;
        for (int num : nums) {
            sum=(sum+num)%p;
        }
        if(sum % p == 0) {
            return 0;
        }
        int remain = sum%p;
        
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        
        int cumulSum = 0;
        
        for (int i=0; i<nums.length; i++) {
            cumulSum=(cumulSum + nums[i])%p;
            int search = cumulSum-remain < 0 ? cumulSum-remain+p : cumulSum-remain;
            if(map.containsKey(search)) {
                len = Math.min(len, i-map.get(search));
            }
            map.put(cumulSum,i);
        }
        
        
        return len == nums.length ? -1 : len;
    }
}