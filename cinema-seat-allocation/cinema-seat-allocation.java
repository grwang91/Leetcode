class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        int ans = n*2;
        
        for (int[] reservedSeat : reservedSeats) {
            int row = reservedSeat[0];
            int col = reservedSeat[1];
            
            if(!map.containsKey(row)) {
                map.put(row, new ArrayList<>());
            }
            map.get(row).add(col);
        }
        
        for (int row : map.keySet()) {
            int canReserve = countValid(map.get(row));
            ans -= 2-canReserve;
        }
        
        return ans;
        
    }
    
    private int countValid(List<Integer> arr) {
        int output = 0;
        
        boolean[] check = new boolean[11];
        for (int x : arr) {
            check[x] = true;
        }
        
        boolean side = false;
        
        if(!check[2] && !check[3] && !check[4] && !check[5]) {
            output++;
            side = true;
        }
        if(!check[6] && !check[7] && !check[8] && !check[9]) {
            output++;
            side = true;
        }
        if(!side && !check[6] && !check[7] && !check[4] && !check[5]) {
            output++;
        }
        
        
        return output;
    }
}