class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        boolean[] right = new boolean[n];
        boolean[] left = new boolean[n];
        List<Integer> ans = new ArrayList<>();
        
        if(time == 0) {
            for (int i=0; i<n; i++) {
                ans.add(i);
            }
            return ans;
        }
        
        int lastUp = 0;
        for (int i=1; i<n; i++) {
            if(security[i] > security[i-1]) {
                lastUp = i;
                continue;
            }
            if(i-lastUp >= time) {
                right[i] = true;
            }
        }
        
        lastUp = n-1;
        for (int i=n-2; i>=0; i--) {
            if(security[i] > security[i+1]) {
                lastUp = i;
                continue;
            }
            if(lastUp-i >= time) {
                left[i] = true;
            }
        }
        
        for(int i=0; i<n; i++) {
            if(left[i] && right[i]) {
                ans.add(i);
            }
        }
        
        return ans;
        
    }
}