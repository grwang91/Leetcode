class Solution {
    public int[] findOriginalArray(int[] changed) {
        int[] ans = new int[changed.length/2];
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : changed) {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        Arrays.sort(changed);
        
        int idx = 0;
        for (int num : changed) {
            if(map.containsKey(num)) {
                map.put(num, map.get(num)-1);
                if(map.get(num)==0) {
                    map.remove(num);
                }
                if(map.containsKey(2*num)) {
                    ans[idx++] = num;
                    map.put(2*num,map.get(2*num)-1);
                    if(map.get(2*num)==0) {
                        map.remove(2*num);
                    }
                } else {
                    return new int[0];
                }
            } else {
                continue;
            }
        }
        
        return ans;
    }
}