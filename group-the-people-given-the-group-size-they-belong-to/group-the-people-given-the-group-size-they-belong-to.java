class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> output = new ArrayList<>();
        Map<Integer, List<Integer>> hash = new HashMap<>();
        
        for (int i=0; i<groupSizes.length; i++) {
            if(!hash.containsKey(groupSizes[i])) {
                hash.put(groupSizes[i], new ArrayList<>());
            }
            hash.get(groupSizes[i]).add(i);
        }
        
        for (int key : hash.keySet()) {
            List<Integer> list = hash.get(key);
            
            List<Integer> tmp = new ArrayList<>();
            for (int i=0; i<list.size(); i++) {
                if(i%key == 0) {
                    tmp = new ArrayList<>();
                }
                tmp.add(list.get(i));
                
                if(i%key == key-1) {
                    output.add(tmp);
                }
            }
            
        }
        
        return output;
        
    }
}