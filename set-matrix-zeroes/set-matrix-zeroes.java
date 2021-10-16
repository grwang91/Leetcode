class Solution {
    public void setZeroes(int[][] matrix) {
        List<Node> zeros = new ArrayList<>();
        
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                if(matrix[i][j] == 0)
                    zeros.add(new Node(i,j));
            }
        }
        
        for (Node n : zeros) {
            for (int i=0; i<matrix[0].length; i++) {
                matrix[n.row][i] = 0;
            }
            for (int i=0; i<matrix.length; i++) {
                matrix[i][n.col] = 0;
            }
        }
    }
    
    class Node {
        int row;
        int col;
        
        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}