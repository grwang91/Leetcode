class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] up = new int[colsum.length];
        int[] down = new int[colsum.length];
        
        for(int i=0; i<colsum.length; i++) {
            if(colsum[i] == 2) {
                up[i] = 1;
                down[i] = 1;
                upper--;
                lower--;
            }
        }
        
        for(int i=0; i<colsum.length; i++) {
            if(colsum[i] == 1) {
                if(upper > 0) {
                    up[i] = 1;
                    upper--;
                } else {
                    down[i] = 1;
                    lower--;
                }
            }
        }
        if(lower != 0 || upper != 0) {
            return ans;
        }
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        for(int i=0; i<up.length; i++) {
            ans.get(0).add(up[i]);
            ans.get(1).add(down[i]);
        }
        
        return ans;
    }
}