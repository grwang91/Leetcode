class Solution {
    public int climbStairs(int n) {
        int pre = 1;
        int pre2 = 1;
        
        for (int i=2; i<=n; i++) {
            int tmp = pre+pre2;
            pre2 = pre;
            pre = tmp;
        }
        
        return pre;
    }
}