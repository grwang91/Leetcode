class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> rems = new HashMap<>(){{
            put(0, -1);
        }};
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            if (k != 0) {
                sum %= k;
            }
            if (!rems.containsKey(sum)) {
                rems.put(sum, i);
            } else if (i - rems.get(sum) >= 2) {
                return true;
            }
        }
        return false;
    }
}