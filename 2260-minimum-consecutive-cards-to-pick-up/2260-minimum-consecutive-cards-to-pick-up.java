class Solution {
    public int minimumCardPickup(int[] cards) {
        int[] check = new int[1000001];
        int ans = cards.length+1;
        int s = 0;
        for(int i=0; i<cards.length; i++) {
            int n = cards[i];
            check[n]++;
            
            boolean flag = false;
            while(check[n] >= 2) {
                flag = true;
                check[cards[s++]]--;
            }
            if(flag) {
                // System.out.println(i+" " + s);
                ans = Math.min(ans, i-s+2);
            }
        }
        return ans==cards.length+1? -1: ans;
    }
}