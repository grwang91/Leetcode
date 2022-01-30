class Solution {
    public int numFriendRequests(int[] ages) {
        int ans = 0;
        Arrays.sort(ages);
        
        for (int i=0; i<ages.length; i++) {
            ans+=i-upperbound(ages, 0, i, ages[i]/2+7)+1;
        }
      
        int num = 0;
        int cnt = 1;
        for (int i=0; i<ages.length; i++) {
            if(num != ages[i]) {
                if(num > num/2+7 && cnt>1) {
                    ans+=cnt*(cnt-1)/2;
                }
                num = ages[i];
                cnt = 1;
            } else {
                cnt++;
            }
        }
        
        if(num > num/2+7 && cnt>1) {
            ans+=cnt*(cnt-1)/2;
        }
        
        return ans;
        
    }
    
    private int upperbound(int[] ages, int s, int e, int target) {
        int m;
        while(s<e) {
            m = (s+e)/2;
            
            if(ages[m]<=target) {
                s = m+1;
            } else {
                e = m;
            }
        }
        
        return e+1;
    }
}