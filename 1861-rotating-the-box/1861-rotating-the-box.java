class Solution {
    public char[][] rotateTheBox(char[][] box) {
        char[][] ans = new char[box[0].length][box.length];
        
        for (int i=0; i<ans.length; i++) {
            for (int j=0; j<ans[0].length; j++) {
                ans[i][j] = box[ans[0].length-1-j][i];
            }
        }
        
        for (int i=ans.length-1; i>=0; i--) {
            for (int j=0; j<ans[0].length; j++) {
                if(ans[i][j] != '.') {
                    continue;
                }
                int row = i;
                while(row >= 0) {
                    if(ans[row][j] == '*') {
                        break;
                    }
                    if(ans[row][j] == '#') {
                        ans[row][j] = '.';
                        ans[i][j] = '#';
                        break;
                    }
                    row--;
                }
            }
        }
        
        return ans;
    }
}