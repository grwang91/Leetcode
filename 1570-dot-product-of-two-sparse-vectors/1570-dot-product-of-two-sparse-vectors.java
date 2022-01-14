class SparseVector {
    Map<Integer, Integer> map;
    SparseVector(int[] nums) {
        map = new HashMap<>();
        
        for (int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                continue;
            }
            map.put(i, nums[i]);
        }
        
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int ans = 0;
        for (int key : map.keySet()) {
            ans+=map.get(key)*vec.map.getOrDefault(key,0);
        }
        return ans;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);