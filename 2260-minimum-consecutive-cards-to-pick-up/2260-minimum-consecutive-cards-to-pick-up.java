class Solution {
    public int minimumCardPickup(int[] cards) {
        int[] check = new int[1000001];
        Arrays.fill(check, -1);
        int ans = cards.length+1;
        for(int i=0; i<cards.length; i++) {
            int n = cards[i];
            if(check[n] != -1) {
                ans = Math.min(ans, i-check[n]+1);
            }
            check[n] = i;
        }
        return ans==cards.length+1? -1: ans;
    }
}