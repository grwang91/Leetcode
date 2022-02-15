class Solution {
    int ans = 0;
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int n = students.length;
        int[][] scoreArr = new int[n][n];
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                scoreArr[i][j] = calculate(students[i], mentors[j]);
            }
        }
        
        backTrack(scoreArr, 0, 0, new boolean[n]);
        
        return ans;
    }
    
    private void backTrack(int[][] scoreArr, int score, int idx, boolean[] check) {
        if(idx == scoreArr.length) {
            ans = Math.max(score, ans);
            return;
        }
        
        for(int i=0; i<scoreArr.length; i++) {
            if(!check[i]) {
                check[i] = true;
                backTrack(scoreArr, score+scoreArr[idx][i], idx+1, check);
                check[i] = false;
            }
        }
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