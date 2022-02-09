class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> ans = new ArrayList<>();
        
        int p1=0, p2=0;
        int cnt1 = 0;
        int cnt2 = 0;
        while(p1 < encoded1.length && p2 < encoded2.length) {
            if(cnt1 == 0) {
                cnt1 = encoded1[p1][1];
            }
            if(cnt2 == 0) {
                cnt2 = encoded2[p2][1];
            }
            
            int multiply = encoded1[p1][0]*encoded2[p2][0];
            int overlap = Math.min(cnt1, cnt2);
            cnt1-=overlap;
            cnt2-=overlap;
            
            
            if(ans.size()==0 || ans.get(ans.size()-1).get(0) != multiply) {
                ans.add(new ArrayList<>(Arrays.asList(multiply, overlap)));
            } else {
                ans.get(ans.size()-1).set(1, ans.get(ans.size()-1).get(1)+overlap);
            }
            
            if(cnt1 == 0) {
                p1++;
            }
            if(cnt2 == 0) {
                p2++;
            }
            
        }
        
        return ans;
    }
}