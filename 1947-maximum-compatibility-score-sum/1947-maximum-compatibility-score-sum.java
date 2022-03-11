class Solution {
    int[][] memo;
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        memo = new int[students.length][(1<<students.length)];
        for(int i=0; i<memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        
        return backTrack(students, mentors, 0, 0);
    }
    
    private int backTrack(int[][] students, int[][] mentors, int mask, int idx) {
        if(idx == students.length) {
            return 0;
        }
        
        if(memo[idx][mask] != -1) return memo[idx][mask];
        
        int max = 0;
        for(int i=0; i<students.length; i++) {
            if((mask&(1<<i))==0) {
                int curr = calculate(students[idx], mentors[i]) + backTrack(students, mentors, mask|(1<<i), idx+1);
                max = Math.max(max, curr);
            }
        }
        
        memo[idx][mask] = max;
        return max;
    }
    
    private int calculate(int[] student, int[] mentors) {
        int out = 0;
        for (int i=0; i<student.length; i++) {
            if(student[i]==mentors[i]) {
                out++;
            }
        }
        return out;
    }
}