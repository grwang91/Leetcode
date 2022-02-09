class Solution {
    public int findPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> pairs = new HashSet<>();
        int ans = 0;
        
        for (int num : nums) {
            if(set.contains(num-k)) {
                if(!pairs.contains(num-k)) {
                    ans++;
                    pairs.add(num-k);
                }
            }
            if(set.contains(num+k)) {
                if(!pairs.contains(num)) {
                    ans++;
                    pairs.add(num);
                }
            }
            set.add(num);
        }
        
        return ans;
    }
}