class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        int n = nums.length;
        int ans = 0;
        Set<String> set = new HashSet<>();
        
        for(int i=1; i<=n; i++) {
            int cnt = 0;
            String s = "";
            for(int j=0; j<i; j++) {
                if(nums[j]%p==0) {
                    cnt++;
                }
                s+=nums[j]+"#";
            }
            if(cnt <=k) {
                if(!set.contains(s)) {
                    ans++;    
                }
                
                set.add(s);
            }
            
            for(int j=i; j<n; j++) {
                if(nums[j]%p == 0) {
                    cnt++;
                }
                if(nums[j-i]%p == 0) {
                    cnt--;
                }
                s+=nums[j]+"#";
                s=s.substring(s.indexOf("#")+1);
                if(cnt<=k) {
                    if(!set.contains(s)) {
                        ans++;    
                    }
                    set.add(s);
                }
            }
        }
        
        return ans;
    }
}