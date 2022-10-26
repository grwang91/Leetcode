class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length < 2) return false;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        
        for(int i=0; i<nums.length; i++) {
            sum=(sum+nums[i])%k;
            if(map.containsKey(sum)) {
                System.out.println(i);
                if(i-map.get(sum) >= 2)
                    return true;
            }
            if(!map.containsKey(sum)) {
                map.put(sum, i);    
            }
            
        }
        return false;
    }
}