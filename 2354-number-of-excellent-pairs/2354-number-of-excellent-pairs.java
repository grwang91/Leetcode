class Solution {
    public long countExcellentPairs(int[] nums, int k) {
        long ans = 0;
        Set<Integer> set = new HashSet<>();
        List<Integer> cnts = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num: nums) {
            if(set.contains(num)) continue;
            set.add(num);
            
            int cnt = count(num);
            map.put(cnt, map.getOrDefault(cnt,0)+1);
        }
        
        for(int i: map.keySet()) {
            for(int j: map.keySet()) {
                if(i+j >= k) {
                    ans+=map.get(i)*map.get(j);
                }
            }
        }
        
        return ans;
    }
    
    private int count(int num) {
        int m = 1;
        int cnt = 0;        
        while(m > 0) {
            if((m&num) > 0) {
                cnt++;
            }
            m<<=1;
        }
        return cnt;
    }
}