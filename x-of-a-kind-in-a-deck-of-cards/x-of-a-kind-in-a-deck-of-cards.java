class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        
        int gcdResult = 0;
        Map<Integer,Integer> map = new HashMap<>();
        
        for (int num : deck) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        for (int key : map.keySet()) {
            int num = map.get(key);
            gcdResult = gcdResult==0? num : gcd(gcdResult,num);
            
        }
        return gcdResult!=1;
    }
    public int gcd(int a, int b){
        if(b == 0){
            return a;
        }else{
            return gcd(b, a%b);
        }
    }

}