class Solution {
    Map<String, Integer> map = new HashMap<>();
    public int minimumXORSum(int[] nums1, int[] nums2) {
        return calc(nums1, nums2, 0, 0);
    }
    
    private int calc(int[] nums1, int[] nums2, int idx, int mask) {
        if(idx == nums1.length) return 0;
        
        String key = idx+"#"+mask;
        if(map.containsKey(key)) return map.get(key);
        
        int min = Integer.MAX_VALUE;
        for(int i=0; i<nums2.length; i++) {
            if((mask&(1<<i)) == 0) {
                int sum = (nums1[idx]^nums2[i]) + calc(nums1, nums2, idx+1, mask|(1<<i));
                min = Math.min(sum, min);
            }
        }
        
        map.put(key, min);
        return min;
    }
}