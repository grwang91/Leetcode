class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<Integer> output = new ArrayList<>();
        
        Arrays.sort(slots1, (i1,i2)->i1[0]-i2[0]);
        Arrays.sort(slots2, (i1,i2)->i1[0]-i2[0]);
        
        int idx1 = 0;
        
        for (int i=0; i<slots2.length; ) {
            if(idx1 == slots1.length) {
                break;
            }
            int intersect = getIntersect(slots1[idx1], slots2[i]);
            if(intersect >= duration) {
                int start = Math.max(slots1[idx1][0], slots2[i][0]);
                int end = start+duration;
                output.add(start);
                output.add(end);
                return output;
            }
            
            if(slots1[idx1][1] > slots2[i][1]) {
                i++;
            } else {
                idx1++;
            }
        }
        
        return output;
    }
    
    private int getIntersect(int[] s1, int[] s2) {
        if(s1[0]>=s2[1] || s2[0] >= s1[1]) {
            return 0;
        }
        
        return Math.min(s1[1], s2[1])-Math.max(s1[0],s2[0]);
    }
}