class Solution {
    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int mod = 1000000007;
        
        for(int num : deliciousness) {
            int power = 1;
            for (int i=0; i<22; i++) {
                if(map.containsKey(power-num)) {
                    ans = (ans+map.get(power-num))%mod;
                }
                power*=2;
            }
            map.put(num, map.getOrDefault(num,0)+1);
        }
        return ans;
    }
}