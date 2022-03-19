class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> intersect = new ArrayList<>();
        
        int a = 0;
        for(int i=0; i<secondList.length; ) {
            if(a == firstList.length) break;
            int start = Math.max(firstList[a][0], secondList[i][0]);
            int end = Math.min(firstList[a][1], secondList[i][1]);
            if(start<=end) {
                intersect.add(new int[]{start,end});
            }
            if(firstList[a][1] < secondList[i][1]) {
                a++;
            } else {
                i++;
            }
        }
        
        int[][] ans = new int[intersect.size()][2];
        for(int i=0; i<ans.length; i++) {
            ans[i] = intersect.get(i);
        }
        return ans;
    }
}