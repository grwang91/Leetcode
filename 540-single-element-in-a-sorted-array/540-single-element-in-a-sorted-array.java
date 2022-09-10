class Solution {
    public int singleNonDuplicate(int[] nums) {
        int m = 0;
        for(int n: nums) {
            m^=n;
        }
        return m;
    }
}