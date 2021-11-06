class Solution {
    public int[] singleNumber(int[] nums) {
        int n = 0;
        
        for (int num: nums) {
            n^=num;
        }
        
        int m = 1;
        while((m&n)==0) {
            m = m << 1;
        }
        
        int n1 = 0;
        int n2 = 0;
        
        for (int num: nums) {
            if((m&num)!=0) {
                n1^=num;
            } else {
                n2^=num;
            }
        }
        
        return new int[]{n1,n2};
    }
}