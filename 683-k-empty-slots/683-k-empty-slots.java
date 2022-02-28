class Solution {
    public int kEmptySlots(int[] bulbs, int k) {
        boolean[] check = new boolean[bulbs.length+1];
        
        for(int i=0; i<bulbs.length; i++) {
            check[bulbs[i]] = true;
            
            if(checkKoffBulbs(bulbs[i]-k, bulbs[i]-1, check)||checkKoffBulbs(bulbs[i]+1, bulbs[i]+k, check)) {
                return i+1;
            }
        }
        
        return -1;
    }
    
    private boolean checkKoffBulbs(int s, int e, boolean[] check) {
        if(s < 2 || e >= check.length-1 || !check[s-1] || !check[e+1]) {
            return false;
        }
        
        for(int i=s; i<=e; i++) {
            if(check[i]) {
                return false;
            }
        }
        return true;
    }

}