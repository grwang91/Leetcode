class Solution {
    public int findMaxLength(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        int cur = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                cur--;
            } else {
                cur++;
            }
            
            if(cur == 0) {
                ans = Math.max(ans, i+1);
            }
            
            if(map.containsKey(cur)) {
                ans = Math.max(ans, i-map.get(cur));
            }
            
            if(!map.containsKey(cur)) {
                map.put(cur,i);
            }
        }
        
        return ans;
    }
}