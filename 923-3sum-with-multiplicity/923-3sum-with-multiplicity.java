class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int ans = 0;
        int MOD = 1000000007;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            map.clear();
            int curTarget = target-arr[i];
            for(int j=0; j<i; j++) {
                if(map.containsKey(curTarget-arr[j])) {
                    ans=(ans+map.get(curTarget-arr[j]))%MOD;
                }
                map.put(arr[j], map.getOrDefault(arr[j],0)+1);
            }
        }
        return ans;
    }
}