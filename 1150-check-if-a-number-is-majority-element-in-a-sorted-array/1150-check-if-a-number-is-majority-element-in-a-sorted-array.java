class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num: nums) {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        
        return map.getOrDefault(target,0) > nums.length/2;
    }
}