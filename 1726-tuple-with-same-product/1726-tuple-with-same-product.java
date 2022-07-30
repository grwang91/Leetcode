class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                int prod = nums[i]*nums[j];
                map.put(prod, map.getOrDefault(prod,0)+1);
            }
        }
        
        for(int key: map.keySet()) {
            int val = map.get(key);
            if(val < 2) continue;
            
            int combi = val*(val-1)/2;
            ans+=combi*8;
        }
        return ans;
    }
}