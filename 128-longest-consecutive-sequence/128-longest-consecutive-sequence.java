class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        
        for (int num : nums) {
            set.add(num);
        }
        
        for (int num : set) {
            if(set.contains(num-1)) {
                continue;
            }
            int len = 1;
            int current = num+1;
            
            while(set.contains(current)) {
                len++;
                current++;
            }
            ans = Math.max(ans,len);
        }
        return ans;
    }
}