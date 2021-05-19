class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        
        int s = 0, e = nums.length-1;
        int moves = 0;
        while(s<e) {
            moves+=nums[e--] - nums[s++];
        }
        
        return moves;
    }
}