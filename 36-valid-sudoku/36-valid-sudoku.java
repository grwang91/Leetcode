class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> row = new ArrayList<>();
        List<Set<Character>> col = new ArrayList<>();
        List<Set<Character>> region = new ArrayList<>();
        
        for (int i=0; i<9; i++) {
            row.add(new HashSet<>());
            col.add(new HashSet<>());
            region.add(new HashSet<>());
        }
        
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                char c = board[i][j];
                if(c=='.') continue;
                
                if(row.get(i).contains(c) || col.get(j).contains(c) || region.get(getRegion(i,j)).contains(c)) {
                    return false;
                }
                
                row.get(i).add(c);
                col.get(j).add(c);
                region.get(getRegion(i,j)).add(c);
            }
        }
        
        return true;
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