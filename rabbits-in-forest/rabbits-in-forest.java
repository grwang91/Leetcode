class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer,Integer> map = new HashMap<>();
        int rabbits = 0;
        
        for (int answer : answers) {
            map.put(answer,map.getOrDefault(answer,0)+1);
        }
        
        for (int answer : map.keySet()) {
            int freq = map.get(answer);
            int num = 1;
            
            while(freq > answer+1) {
                freq-=answer+1;
                num++;
            }
            rabbits+=num*(answer+1);
        }
        
        return rabbits;
    }
}