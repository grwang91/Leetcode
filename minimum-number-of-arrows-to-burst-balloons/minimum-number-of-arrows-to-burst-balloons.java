class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(p1,p2)->p1[1]==p2[1]? Integer.compare(p1[0],p2[0]) : Integer.compare(p1[1],p2[1]));
        
        int shots = 0;
        for (int i=0; i<points.length; ) {
            int end = points[i][1];
            shots++;
            i++;
            while(i<points.length && points[i][0] <= end) {
                i++;
            }
        }
        
        return shots;
    }
}