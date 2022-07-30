class Solution {
    public String largestNumber(int[] cost, int target) {
        String[] dp = new String[target+1];
        dp[0] = "";
        Map<Integer, String> map = new HashMap<>();
        
        for(int i=0; i<cost.length; i++) {
            int c = cost[i];
            map.put(c, Integer.toString(i+1));
        }
        
        for(int i=1; i<=target; i++) {
            for(int key: map.keySet()) {
                String dig = map.get(key);
                if(i-key >=0 && dp[i-key] != null) {
                    String next = dp[i-key]+dig;
                    dp[i] = dp[i] == null? next: bigger(dp[i], next)? dp[i]: next;
                }
            }
        }
        
        return dp[target]==null? "0": dp[target];
    }
    
    private boolean bigger(String a, String b) {
        if(a.length() > b.length()) return true;
        if(a.length() < b.length()) return false;
        
        for(int i=0; i<a.length(); i++) {
            if(a.charAt(i)==b.charAt(i)) continue;
            
            if(a.charAt(i) > b.charAt(i)) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }
}