class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1,p2)->p1[0]==p2[0]? -p1[1]+p2[1]:p1[0]-p2[0]);
        
        int[][] ans = new int[people.length][2];
        // List<Integer> check = new ArrayList<>();
        boolean[] check = new boolean[people.length];
        // for (int i=0; i<people.length; i++) {
        //     check.add(i);
        // }
        
        for (int[] p : people) {
            int idx = 0;

            int iter = p[1];
            while(iter > 0) {
                if(!check[idx]) {
                    iter--;
                }
                idx++;
            }
             while(check[idx]) {
                idx++;
            }
            
            check[idx] = true;
            ans[idx] = p;

        }
        
        return ans;
    }
}