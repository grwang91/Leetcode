class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        List<Integer> ans = new ArrayList<>();
        
        int[][] left = new int[colors.length][4];
        int[][] right = new int[colors.length][4];
        
        int one = -1;
        int two = -1;
        int three = -1;
        
        //left to right
        for(int i=0; i<colors.length; i++) {
            if(colors[i] == 1) {
                one = i;
            } else if (colors[i] ==2) {
                two = i;
            } else {
                three = i;
            }
            
            left[i][1] = one == -1? Integer.MAX_VALUE : i-one;
            left[i][2] = two == -1? Integer.MAX_VALUE: i-two;
            left[i][3] = three == -1? Integer.MAX_VALUE: i-three;
        }
        
        one = -1;
        two = -1;
        three = -1;
        //right to left
        for(int i=colors.length-1; i>=0 ; i--) {
            if(colors[i] == 1) {
                one = i;
            } else if (colors[i] ==2) {
                two = i;
            } else {
                three = i;
            }
            
            right[i][1] = one == -1? Integer.MAX_VALUE : -i+one;
            right[i][2] = two == -1? Integer.MAX_VALUE: -i+two;
            right[i][3] = three == -1? Integer.MAX_VALUE: -i+three;
        }
        
        for(int[] query : queries) {
            int min = Math.min(left[query[0]][query[1]], right[query[0]][query[1]]);
            ans.add(min == Integer.MAX_VALUE? -1 : min);
        }
        return ans;
    }
}