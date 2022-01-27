class Solution {
    public void solveSudoku(char[][] board) {
        List<Set<Character>> row = new ArrayList<>();
        List<Set<Character>> col = new ArrayList<>();
        List<Set<Character>> region = new ArrayList<>();
        int cnt = 0;
        
        for (int i=0; i<9; i++) {
            row.add(new HashSet<>());
            col.add(new HashSet<>());
            region.add(new HashSet<>());
        }
        
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                char c = board[i][j];
                if(c=='.') {
                    continue;
                }
                cnt++;
                row.get(i).add(c);
                col.get(j).add(c);
                region.get(getRegion(i,j)).add(c);
            }
        }
        
        backTrack(board, row, col, region, cnt);
    }
    
    private boolean backTrack(char[][] board, List<Set<Character>> row, List<Set<Character>> col, List<Set<Character>> region, int cnt) {
        if(cnt == 81) {
            return true;
        }
        
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if(board[i][j]!='.') {
                    continue;
                }
                int regionNum = getRegion(i,j);
                for (int k=1; k<=9; k++) {
                    char c = (char)(k+'0');
                    if(!row.get(i).contains(c) && !col.get(j).contains(c) && !region.get(regionNum).contains(c)) {
                        board[i][j] = c;
                        row.get(i).add(c);
                        col.get(j).add(c);
                        region.get(regionNum).add(c);
                        boolean isCompleted = backTrack(board, row, col, region, cnt+1);
                        if(isCompleted) {
                            return true;
                        }
                        board[i][j] = '.';
                        row.get(i).remove(c);
                        col.get(j).remove(c);
                        region.get(regionNum).remove(c);
                    }
                }
                return false;
            }
        }
        
        return false;
    }
    
    
    private int getRegion(int i, int j) {
        if(i<3) {
            if(j<3) {
                return 0;
            } else if (j<6) {
                return 1;
            } else {
                return 2;
            }
        } else if (i<6) {
            if(j<3) {
                return 3;
            } else if (j<6) {
                return 4;
            } else {
                return 5;
            }
        } else {
            if(j<3) {
                return 6;
            } else if (j<6) {
                return 7;
            } else {
                return 8;
            }
        }
    }
}